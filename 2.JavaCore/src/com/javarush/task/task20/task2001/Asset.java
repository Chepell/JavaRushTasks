package com.javarush.task.task20.task2001;

import java.io.Serializable;

// класс активов
//public class Asset {
public class Asset implements Serializable {
    // приватные поля класса
    private String name;
    private double price;

    // единственный публичный конструктор
    public Asset(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // публичные геттеры класа
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // переопределение метода сравнения объектов класса
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        return name != null ? name.equals(asset.name) : asset.name == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
