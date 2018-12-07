package com.javarush.task.task24.task2401;

// класс реализующий интерфейс-маркер
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {

    // просто методы класса
    public void msg() {
        System.out.println("This is just a message...");
    }


    public int getId() {
        return 423;
    }
}
