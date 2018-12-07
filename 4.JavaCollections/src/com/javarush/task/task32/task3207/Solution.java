package com.javarush.task.task32.task3207;

import com.sun.org.apache.xpath.internal.axes.ReverseAxesWalker;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
К серверу по RMI
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "double.string";
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            //напишите тут ваш код
            try {
                // т.к. все в одном классе работает, то создавать повторно ресстре не нужно
//                Registry registry = LocateRegistry.getRegistry("localhost", 2099);
                // вызов из реестра объекта интерфейса по уникальному имени
                DoubleString service = (DoubleString) registry.lookup(UNIC_BINDING_NAME);
                // Вызов метода на сервисе
                String result = service.doubleString("Not empty arg");
                System.out.println(result);
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) { // если поиск по уникальному имени в реестре прошел неудачно
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) {
        //pretend we start rmi server as main thread
        // запуск серера
        Remote stub = null;
        try {
            // создание реестра расшаренных объектов
            registry = LocateRegistry.createRegistry(2099);
            // создание самого объекта для удаленного доступа
            final DoubleStringImpl service = new DoubleStringImpl();
            // создание "заглушки" приемника удаленных вызовов
            // Заглушка - спец.объект принимающий информацию об удаленном вызове распаковывает,
            // дерсерелизует, а затем ответ направляет в обратном направлении
            stub = UnicastRemoteObject.exportObject(service, 0);
            // регистрация заглушки в реестре под уникальным именем
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

        //start client
        CLIENT_THREAD.start();
    }
}