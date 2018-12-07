package com.javarush.task.task17.task1712;

// класс столика
public class Table {
    // статичное поле инициируется нулем при
    // первичной инициализации класса
    private static byte tableNumber;
    // поле номера столика
    // пре-инкрементируется при создании каждого объекта
    private byte number = ++tableNumber;

    // геррет для получения нового заказа
    // для текущего столика
    public Order getOrder () {
        // создается новый объект класса Order c параметром - номером текущего стола
        return new Order(number);
    }
}
