package com.javarush.task.task21.task2112;

// класс с методом создающим объект класса FakeConnection
public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
