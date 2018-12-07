package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.javarush.task.task30.task3008.ConsoleHelper.*;
import static com.javarush.task.task30.task3008.MessageType.*;

public class BotClient extends Client {
    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            // и вызываю реализацию родительского класса
            // т.е. фактически просто добавил отправку всем сообщения вначале работы
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            if (message != null) {
                writeMessage(message);
                SimpleDateFormat format;
                if (message.contains(": ")) {
                    String[] massiv = message.split(": ");
                    if (massiv.length == 2 && massiv[1] != null) {
                        String name = massiv[0];
                        String text = massiv[1];
                        Map<String, SimpleDateFormat> mapFormatter = new HashMap<>();
                        mapFormatter.put("дата", new SimpleDateFormat("d.MM.YYYY"));
                        mapFormatter.put("день", new SimpleDateFormat("d"));
                        mapFormatter.put("месяц", new SimpleDateFormat("MMMM"));
                        mapFormatter.put("год", new SimpleDateFormat("YYYY"));
                        mapFormatter.put("время", new SimpleDateFormat("H:mm:ss"));
                        mapFormatter.put("час", new SimpleDateFormat("H"));
                        mapFormatter.put("минуты", new SimpleDateFormat("m"));
                        mapFormatter.put("секунды", new SimpleDateFormat("s"));
                        format = mapFormatter.get(text);
                        if (format != null) {
                            Date time = Calendar.getInstance().getTime();
                            sendTextMessage(String.format("Информация для %s: %s", name, format.format(time)));
                        }
                    }
                }
            }
        }
    }
}


//Указанный выше формат используй для создания объекта SimpleDateFormat.
// Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
//Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например,
// если Боб отправил запрос "время", мы должны отправить ответ "Информация для Боб: 12:30:47".
//Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
//Помни, что message бывают разных типов и не всегда содержат ":"
