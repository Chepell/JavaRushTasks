package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Arrays;

/* 
RMI-2
*/
public class Solution {
    public static final String UNIC_BINDING_NAME = "animal: ";
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // создание реестра расшаренных объектов
                registry = LocateRegistry.createRegistry(2099);
                // создание объектов для удаленного доступа
                final Cat cat = new Cat("Rich");
                final Dog dog = new Dog("Hachiko");
                // создание заглушек/приемников для удаленного вызова объектов
                Remote remoteCat = UnicastRemoteObject.exportObject(cat, 0);
                Remote remoteDog = UnicastRemoteObject.exportObject(dog, 0);
                // регистрация заглушек в реестре, уникальный текстовый ключ для каждой заглушки
                registry.bind(UNIC_BINDING_NAME + 1, remoteCat);
                registry.bind(UNIC_BINDING_NAME + 2, remoteDog);
            } catch (RemoteException e) {
//                e.printStackTrace();
                System.err.println(e);
            } catch (AlreadyBoundException e) {
//                e.printStackTrace();
                System.err.println(e);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}

//Реализуй логику метода run в SERVER_THREAD. В нем будет имитироваться серверная часть:
//1) Инициализируй поле registry, которое будет принимать и обрабатывать запросы на 2099 порту.
//2) Создай два объекта - Cat и Dog.
//3) Используй класс UnicastRemoteObject, чтобы создать Remote объекты для созданных Cat и Dog.
//Remote объекты будут в состоянии принимать обращения к своим методам используя выбранный порт (2099).
//4) Для Cat и Dog добавь в registry связь уникального текстового ключа и Remote объекта. Текстовый ключ придумай сам.
//5) При возникновении любого исключения выведи его стек-трейс в поток System.err.
//Метод main не участвует в тестировании.
//
//
//Требования:
//1. В методе run() необходимо инициализировать поле registry. Для этого используй LocateRegistry.createRegistry (2099).
//2. В методе run() необходимо создать два объекта - Cat и Dog.
//3. В методе run() необходимо создать Remote объекты для созданных Cat и Dog используя UnicastRemoteObject.exportObject (Remote, int).
//4. Для Cat и Dog нужно добавить в registry связь уникального текстового ключа и Remote объекта используя registry.bind (String, Remote).
//5. При возникновении любого исключения нужно вывести его стек-трейс в поток System.err используя метод printStackTrace ().