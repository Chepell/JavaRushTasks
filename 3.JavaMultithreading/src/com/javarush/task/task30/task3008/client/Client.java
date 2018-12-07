package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

import static com.javarush.task.task30.task3008.ConsoleHelper.*;
import static com.javarush.task.task30.task3008.MessageType.*;

// Обмен сообщениями будет происходить в двух параллельно работающих потоках.
// Один будет заниматься чтением из консоли и отправкой прочитанного серверу,
// а второй поток будет получать данные от сервера и выводить их в консоль.
public class Client {
    // модификатор который позволит обращаться к этому полю из класса потомков,
    // но запретит обращение из других классов вне пакета
    protected Connection connection;
    // для совместного использования в нескольких потоках
    private volatile boolean clientConnected;

    // метод для запроса адреса сервера
    protected String getServerAddress() {
        writeMessage("Input server address:");
        return readString();
    }

    // метод для запроса номера порта
    protected int getServerPort() {
        writeMessage("Input server port:");
        return readInt();
    }

    // метод для запроса имени пользователя для чата
    protected String getUserName() {
        writeMessage("Input your name:");
        return readString();
    }

    // флаг разрешаюший клиенту отправлять сообщения с консоли
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    // метод для отправки сообщения на сервер
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(TEXT, text));
        } catch (IOException e) {
            writeMessage("Can't send message");
            clientConnected = false;
        }
    }

    // метод создает и возвращает объект внутреннего класса
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }


    public void run() {
        // вспомогательный поток демон, завершится вместес с главным потоком
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            // синхронизация на потоке объекта
            synchronized (this) {
                // отдаю мьютекс объекта и жду notify из другого потока
                wait();
            }
        } catch (InterruptedException e) {
            writeMessage("Synchronized thread error!");
            System.exit(1);
        }

        // если есть подключение
        if (clientConnected) {
            writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
            // цикл продолжается, пока клиент подключен
            while (clientConnected) {
                // считываю строку с консоли
                String message = readString();
                // условие завершения потока
                if ("exit".equalsIgnoreCase(message)) break;
                // если отправка сообщений клиенту разрешена, то отправляю
                if (shouldSendTextFromConsole()) {
                    sendTextMessage(message);
                }
            }
        } else {
            writeMessage("Произошла ошибка во время работы клиента.");
        }
    }

    // главный метод класса
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

    // Класс отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
    public class SocketThread extends Thread {
        // protected - доступны классам потомкам, но недоступны другим классам вне пакета

        // метод выводит текст в консоль
        protected void processIncomingMessage(String message) {
            writeMessage(message);
        }

        // метод выводит в консоль сообщение что участник присоединился к чату
        protected void informAboutAddingNewUser(String userName) {
            writeMessage(userName + " joint to chat!");
        }

        // метод выводит в консоль сообщение что участник покинул чат
        protected void informAboutDeletingNewUser(String userName) {
            writeMessage(userName + " left chat!");
        }

        // метод устанавливает значение поля объекта внешнего класса
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                // оповещает (пробуждать ожидающий) основной поток класса Client
                Client.this.notify();
            }
        }

        // метод для знакомства с сервером
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                Message receiveMessage = connection.receive();
                MessageType type = receiveMessage.getType();
                String data = receiveMessage.getData();
                // получен запрос имени
                if (type == NAME_REQUEST) {
                    connection.send(new Message(USER_NAME, getUserName()));
                } else if (type == NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    break;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        // метод для обработки сообщений сервера
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            // бесконечный цикл будет прерван в случае исключения или завершения потока
            while (true) {
                // получаю сообщение от сервера
                Message receiveMessage = connection.receive();
                MessageType type = receiveMessage.getType();
                String data = receiveMessage.getData();
                // получен запрос имени
                if (type == TEXT) {
                    processIncomingMessage(data);
                } else if (type == USER_ADDED) {
                    informAboutAddingNewUser(data);
                } else if (type == USER_REMOVED) {
                    informAboutDeletingNewUser(data);
                } else { // если сообщение любого другого типа, то бросаю исключение
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        // переопределение метода многопоточности
        @Override
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress, serverPort);
                // инициирую поле объекта внешнего класса
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                // если словил сключение, то меняю состояниие поля внешнего класса
                notifyConnectionStatusChanged(false);
            }
        }
    }
}
