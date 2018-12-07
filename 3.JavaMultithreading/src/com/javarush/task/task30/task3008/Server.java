package com.javarush.task.task30.task3008;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.javarush.task.task30.task3008.ConsoleHelper.readInt;
import static com.javarush.task.task30.task3008.ConsoleHelper.writeMessage;
import static com.javarush.task.task30.task3008.MessageType.*;

// основной класс сервера
public class Server {
    // потокобезопасный мэп для хранения пар имяПользователя: объект класса Connection с ним
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    // точка запуска сервера
    public static void main(String[] args) {
        // запрос ввода порта для сервера
        writeMessage("Input port number:");
        int port = readInt();
        // в блоке try-with-resources создаю серверный сокет
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            writeMessage("Server start!"); // сообщаю что сервер успешно запущен
            // в бесконечном цикле жду вызовы на сокет
            while (true) {
                Socket newSocket = serverSocket.accept();
                // и передаю их в многопоточный обработчик и сразу запускаю нить
                new Handler(newSocket).start();
            }
        } catch (Exception e) { // если сервер не запустился ловлю исключение и вывожу сообщение
            writeMessage("ServerSocket building error");
        }
    }

    // метод для отправки сообщений сразу всем
    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                // по value у объекта класса Connection из мепа вызываю метод отправки
                pair.getValue().send(message);
            } catch (IOException e) {
                writeMessage("Error! Can't send message");
            }
        }
    }


    // многопоточный обработчик для каждого нового клиента обращающегося к серверу
    // протокол общения с клиентом
    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        // метод для первоначального контакта клиента с сервером
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                // запрос сервером имени
                connection.send(new Message(NAME_REQUEST));
                // полученный ответ от клиента сохраняю в переменную
                Message receiveMessage = connection.receive();
                MessageType receiveType = receiveMessage.getType();
                String receiveData = receiveMessage.getData();
                // если сообщение имеет неверный тип или само сообщение null или пустое
                // то прерываю цикл и начинаю сначала с запроса имени пользователя
                if (receiveType != USER_NAME || receiveData == null || receiveData.isEmpty()) continue;
                // если с типом сообщения все ок, и имя нормальное, но имя уже есть в мэпе пользователей
                // то опять перываю цикл и запрашиваю заново
                if (connectionMap.containsKey(receiveData)) continue;
                // теперь можно добавить пользователя в мэп
                // ключем полученное имя в сообщении
                // значением конеекшн переданный параметром в метод
                connectionMap.put(receiveData, connection);
                // отправляю клиенту подтвержение принятия имени
                connection.send(new Message(NAME_ACCEPTED, receiveData));
                // и в конце возвращая имя покидаю цикл
                return receiveData;
            }
        }

        // метод для отправки новому пользователю списка всех текущих пользователей
        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            // циклом иду по множеству ключей
            for (String key : connectionMap.keySet()) {
                // если текущий ключ из мэпа не равен пользователю переданном в сигнатуре метода
                // то отправляю на коннекшн текущего юзера объект сообщения с типом USER_ADDED и имя
                if (!key.equals(userName)) connection.send(new Message(USER_ADDED, key));
            }
        }

        // метод с помощью которого сервер транслирует полученное от пользователя текстовое сообщение всем участникам
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                // получаю сообщение от пользователя
                Message receiveMessage = connection.receive();
                // разбираю на поля
                MessageType type = receiveMessage.getType();
                String data = receiveMessage.getData();
                // если тип сообщения текст
                if (type == TEXT) {
                    // форматирую строку
                    String msg = String.format("%s: %s", userName, data);
                    // создаю объект типам Message
                    Message message = new Message(TEXT, msg);
                    // используя статичный метод внешнего класса рассылаю сообщение по всему списку
                    // в т.ч. и отправителю, что бы оно отобразилось в ином окне
                    Server.sendBroadcastMessage(message);
                } else {
                    // если тип сообщения другой, то вывожу ошибку
                    writeMessage("Error in main loop");
                }
            }
        }

        @Override
        public void run() {
            SocketAddress address = socket.getRemoteSocketAddress();
            writeMessage("Setup new connection to " + address);
            try (Connection connection = new Connection(socket)) {
                String newUserName = serverHandshake(connection);
                // рассылка всем участникам сообщения о добавлении нового юзера
                Server.sendBroadcastMessage(new Message(USER_ADDED, newUserName));
                // получение новым юзером списка всех юзеров
                sendListOfUsers(connection, newUserName);
                // главный цикл общаения клиента с сервером
                serverMainLoop(connection, newUserName);
                // удаление юзера из списка
                connectionMap.remove(newUserName);
                // информирование всех остальных участников, что юзер удален
                sendBroadcastMessage(new Message(USER_REMOVED, newUserName));
            } catch (IOException | ClassNotFoundException e) {
                writeMessage("Error connection with remote server");
            }
            writeMessage("Connection was closed");
        }
    }
}

// Сервер должен поддерживать множество соединений с разными клиентами одновременно.
// Это можно реализовать с помощью следующего алгоритма:
//- Сервер создает серверное сокетное соединение.
//- В цикле ожидает, когда какой-то клиент подключится к сокету.
//- Создает новый поток обработчик Handler, в котором будет происходить обмен сообщениями с клиентом.
//- Ожидает следующее соединение.