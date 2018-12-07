package com.javarush.task.task17.task1712;

// класс заказа
public class Order {
    // поле времени приготовления
    // будет использоваться у объекта класса Cook
    private long time;
    // номер стола, передается в объект Cook, а затем в в объект класса Dishes
    private byte tableNumber;

    // конструктор получает номер стола
    public Order(byte tableNumber) {
        // поле времени приготовления заполняется случайным значением
        time = (long) (Math.random() * 200);
        this.tableNumber = tableNumber;
    }

    // геттеры
    public long getTime() {
        return time;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
