package com.javarush.task.task24.task2401;

import java.lang.reflect.Method;

public class Util {
    //пример того, как можно использовать интерфейс-маркер
    //this method is available only for a SelfInterfaceMarker implementation
    // статичный методы класса принимающий только объекты типа интенрфейса
    public static void testClass(SelfInterfaceMarker interfaceMarker) throws UnsupportedInterfaceMarkerException {
        // бросаю свой эксепшн в случае указания нулевой переменной
        if (interfaceMarker == null) throw new UnsupportedInterfaceMarkerException();
        // циклом иду по массиву всех методов
        for (Method method : interfaceMarker.getClass().getDeclaredMethods()) {
            // и вывожу их на экран
            System.out.println(method);
        }
    }
}
