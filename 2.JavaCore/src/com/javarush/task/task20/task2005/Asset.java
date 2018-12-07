package com.javarush.task.task20.task2005;

// класс активов
public class Asset {
    // приватные поля класса
    private String name;
    private double price;

    // конструктор класса
    public Asset(String name) {
        this.name = name;
    }

    // геттеры для методов
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    // сеттер для поля price, т.к. в конструкторе нет инициализации поля
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Asset asset = (Asset) o;

        if (Double.compare(asset.price, price) != 0) return false;
        // если имя не пустое, то сравниваю имена иначе и имя поданное для сравнения тоже пустое
        if (name != null ? name.equals(asset.name) : asset.name == null) {
            return true;
        } else {
            return false;
        }

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
