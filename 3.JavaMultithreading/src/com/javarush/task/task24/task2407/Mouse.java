package com.javarush.task.task24.task2407;

/*
обратите внимание, как именно Mouse отличается от Cat
Этот класс - привычный для вас.
*/

// обычный класс с двумя интерфейсами
public class Mouse implements Pet, Sayable {
    // возвращает текущий объект
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    // возвращает строку
    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
