package com.javarush.task.task22.task2201;

// свой класс исключений, наследник ок RuntimeException
public class TooShortStringSecondThreadException extends RuntimeException {
    // переопределяю конструктор по умолчанию, который будет ловить параметром исключение
    public TooShortStringSecondThreadException(Exception cause) {
        // и передавать его в базовый конструктор в качестве причины
        super(cause);
    }
}
