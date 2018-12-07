package com.javarush.task.task27.task2710;

/* 
Расставьте wait-notify
*/
public class Solution {
    public static void main(String[] args) {
        // создаю инстанс письма
        Mail mail = new Mail();
        // создаю потоки сервера и отправителя параметром в них передаю объект письма
        Thread server = new Thread(new MailServer(mail));
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}
