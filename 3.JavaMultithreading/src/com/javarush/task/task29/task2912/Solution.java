package com.javarush.task.task29.task2912;

/* 
Рефакторинг паттерна Chain of Responsibility
*/

public class Solution {
    public static void main(String[] args) {
        // создаю объекты логеров и опередеяю для них в конструкторе
        // уровни тревоги в виде статичный полей класса Level
        Logger logger3 = new PhoneLogger(Level.FATAL);
        Logger logger2 = new SmsLogger(Level.ERROR);
        Logger logger1 = new ConsoleLogger(Level.WARN);
        Logger logger0 = new FileLogger(Level.INFO);

        // вызов методов для объектов класса, которые позволяют выстроить цепочку ответственности
        logger3.setNext(logger2);
        logger2.setNext(logger1);
        logger1.setNext(logger0);

        // вызывается метод на самом старшем логере, директоре, а он проверяет уровень и по цепочке передает вниз
        // сообщая текущему логеру только если уровень переданной ошибки >= уровня заданного в логгере
        logger3.inform("All OK", Level.INFO);
        logger3.inform("We find a bug", Level.WARN);
        logger3.inform("Database connection error", Level.ERROR);
        logger3.inform("System shut down", Level.FATAL);
    }
}