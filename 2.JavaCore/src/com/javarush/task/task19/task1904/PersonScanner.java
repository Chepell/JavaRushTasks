package com.javarush.task.task19.task1904;

import java.io.IOException;

// есть интерфейс
public interface PersonScanner {
    // метод объекта Person для чтения объекта
    Person read() throws IOException;

    // метод будет закрывать объект
    void close() throws IOException;
}
