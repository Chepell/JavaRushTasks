package com.javarush.task.task32.task3207;

import java.rmi.Remote;
import java.rmi.RemoteException;

// интрфейс для межпрограмного взаимодействия с интерфейс-маркером Remote
public interface DoubleString extends Remote {
    // сигнатура метода для дальнейшей реализации
    String doubleString(String str) throws RemoteException;
}