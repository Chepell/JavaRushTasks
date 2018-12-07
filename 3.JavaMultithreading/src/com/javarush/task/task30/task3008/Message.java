package com.javarush.task.task30.task3008;

import java.io.Serializable;

// класс отвечающий за пересылаемы сообщения
public class Message implements Serializable {
    private final MessageType type;
    private final String data;

    // конструктор сообщений с пустой датой для сервисных сообщений сервера
    // NAME_REQUEST, NAME_ACCEPTED
    // запрос имени и подтверждение
    public Message(MessageType type) {
        this.type = type;
        data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    //region гетеры
    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
    //endregion
}

// Сообщение Message - это данные, которые одна сторона отправляет, а вторая принимает.
//Каждое сообщение должно иметь тип MessageType, а некоторые и дополнительные
//данные, например, текстовое сообщение должно содержать текст. Т.к. сообщения будут
//создаваться в одной программе, а читаться в другой, удобно воспользоваться механизмом
//сериализации для перевода класса в последовательность битов и наоборот.