package com.javarush.task.task29.task2912;

// интерфейс логгер
public interface Logger {
    // методы для реализации

    // пришимает сообщение и уровень
    void inform(String message, int level);

    // устанавливает сделующий логгер
    void setNext(Logger next);

    // преобразует сообщение в нужный вид
    void info(String message);
}