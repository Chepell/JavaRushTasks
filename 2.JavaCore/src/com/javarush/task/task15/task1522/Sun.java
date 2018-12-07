package com.javarush.task.task15.task1522;

public class Sun implements Planet {
    private String name;
    // сделать приватное статичное поле содержащее объект класса
    private static Sun instance;

    // сделать приватный конструктор по умолчанию
    private Sun() {
        this.name = SUN;
    }

    // публичный статичный метод созания объекта
    // lazy initialization т.к. объект создается тут, по требованию
    public static Sun getInstance() {
        // если экземпляр еще не создан, то создать
        if (instance == null) instance = new Sun();
        return instance;
    }
}
