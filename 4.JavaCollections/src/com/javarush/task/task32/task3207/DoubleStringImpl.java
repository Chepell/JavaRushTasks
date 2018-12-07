package com.javarush.task.task32.task3207;

import java.rmi.RemoteException;

// Серверный класс с реализацией интерфейса
public class DoubleStringImpl implements DoubleString {
    public String doubleString(String str) throws RemoteException {
        return str + str;
    }
}