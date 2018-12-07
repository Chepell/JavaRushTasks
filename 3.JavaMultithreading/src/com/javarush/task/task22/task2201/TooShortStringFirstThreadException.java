package com.javarush.task.task22.task2201;

// свой класс исключений, наследник от RuntimeException
public class TooShortStringFirstThreadException extends RuntimeException {
    // переопределяю конструктор по умолчанию, который будет ловить параметром исключение
    public TooShortStringFirstThreadException(Exception cause) {
        // и передавать его в базовый конструктор в качестве причины
        super(cause);
    }
}
