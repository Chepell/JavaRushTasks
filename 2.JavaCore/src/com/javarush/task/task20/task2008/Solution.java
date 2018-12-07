package com.javarush.task.task20.task2008;

import java.io.*;

/* 
Как сериализовать Singleton?
Два десериализованных объекта singleton и singleton1 имеют разные ссылки в памяти, а должны иметь одинаковые.
В класс Singleton добавь один метод (погуглите), чтобы после десериализации ссылки на объекты были равны.
Метод main не участвует в тестировании.


Требования:
1. Класс Solution.Singleton должен поддерживать интерфейс Serializable.
2. В классе Solution.Singleton должен быть реализован метод readResolve без параметров.
3. Метод readResolve должен возвращать синглтон (ourInstance).
4. Метод readResolve должен быть приватным.
5. В классе Solution должен быть публичный статический метод serializeSingletonInstance.
6. После десериализации ссылки на объекты должны быть равны.
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // создается экземпляр типа сингтон
        Singleton instance = Singleton.getInstance();
        // создание байтового массива для сохранния
        ByteArrayOutputStream byteArrayOutputStream = serializeSingletonInstance(instance);

        // восстановления объектов из байтового массива
        Singleton singleton = deserializeSingletonInstance(byteArrayOutputStream);
        Singleton singleton1 = deserializeSingletonInstance(byteArrayOutputStream);

        System.out.println("Проверка ourInstance : " + singleton.getInstance());
        System.out.println("Проверка ourInstance : " + singleton1.getInstance());
        System.out.println("=========================================================");
        System.out.println("Проверка singleton : " + singleton);
        System.out.println("Проверка singleton1 : " + singleton1);
    }

    // метод принимает объект синглтона и возвращает байтовый массив
    public static ByteArrayOutputStream serializeSingletonInstance(Singleton instance) throws IOException {
        // созаю байтовый массив
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // создаю объект сохранения объекта и аргументом подаю туда буфферный
        ObjectOutputStream oos = new ObjectOutputStream(byteArrayOutputStream);
        // и записываю объект в буфферный массив
        oos.writeObject(instance);
        // закрываю поток
        oos.close();
        // возвращаю байтовый массив с сохраненным объектом
        return byteArrayOutputStream;
    }

    // метод принимает байтовый массив с сохраненным объектом
    public static Singleton deserializeSingletonInstance(ByteArrayOutputStream byteArrayOutputStream) throws IOException, ClassNotFoundException {
        // создаю байтовый массив на основе параметра
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        // объект чтения
        ObjectInputStream ois = new ObjectInputStream(byteArrayInputStream);
        // создаю объект синглтона в который читаю объект из потока с принудительным приведением типа
        Singleton singleton = (Singleton) ois.readObject();
        // закрываю поток
        ois.close();
        // возвращаю объект
        return singleton;
    }

    public static class Singleton implements Serializable {
        // объект
        private static Singleton ourInstance;

        // конструктор
        private Singleton() {
        }

        // лениваая инициализация
        public static Singleton getInstance() {
            if (ourInstance == null) {
                ourInstance = new Singleton();
            }
            return ourInstance;
        }

        // метод для безболезненной сериализации/десериализации
        private Object readResolve() {
            return ourInstance;
        }
    }
}
