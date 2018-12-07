package com.javarush.task.task17.task1706;

public class OurPresident {
    // статичное поле класса, сам объект этого класса
    private static OurPresident president;

    // т.к. статик-блок относится ко всему классу, един для всего класса, всех его объектов
    static {
        // то и синхронизация по всему классу
        synchronized (OurPresident.class) {
            // в статическом блоке синхронизированная инициализация объекта
            // мьютекс занят, другие нити сюда не попадут
            president = new OurPresident();
        }
    }


    // приватный конструктор
    // недоступен извне
    private OurPresident() {
    }

    // публичный метод получени объекта singletone извне
    public static OurPresident getOurPresident() {
        return president;
    }
}
