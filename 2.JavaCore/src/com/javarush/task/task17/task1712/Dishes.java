package com.javarush.task.task17.task1712;

// класс готового блюда
public class Dishes {
    // единственное поле, номер столка куда нужно блюдо отнести
    private byte tableNumber;

    // конструктор с номером столка
    public Dishes(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    // геттер получения стола
    public byte getTableNumber() {
        return tableNumber;
    }
}
