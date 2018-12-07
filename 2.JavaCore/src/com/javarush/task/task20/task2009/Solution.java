package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
Сделай так, чтобы сериализация класса ClassWithStatic была возможной.


Требования:
1. Класс ClassWithStatic должен существовать внутри класса Solution.
2. Класс ClassWithStatic должен быть статическим.
3. Класс ClassWithStatic должен быть публичным.
4. Класс ClassWithStatic должен поддерживать интерфейс Serializable.
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        // статичное поле класса на которое нужно обратьить внимание при сериализации
        public static String staticString = "it's test static string";
        public int i;
        public int j;

        public ClassWithStatic(int i, int j) {
            this.i = i;
            this.j = j;
        }

        // что бы статичное поле без проблем сериализовывалось нужно переопределить
        // стандартные методы сериализации объектов которые вызываются по умолчанию
        private void writeObject(ObjectOutputStream outputStream) throws IOException {
            // сначала вызывается метод сериализации по умолчанию для объекта
            outputStream.defaultWriteObject();
            // а тут сериализируется наше статичное поле
            outputStream.writeObject(staticString);
        }

        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
            // вызов метода по умолчанию
            inputStream.defaultReadObject();
            // десериализация статичного поля
            staticString = (String) inputStream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // создаем временный файл
        File objectFile = File.createTempFile("objectWhithStaticFild",".bin");
        // потоки вывода объекта в файл
        OutputStream outputStream = new FileOutputStream(objectFile);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        // создаем объект класса
        ClassWithStatic withStatic = new ClassWithStatic(10, 99);
        // инициируем статичное поле
        ClassWithStatic.staticString = "***********";

        // вызываем стандартный метод записи объекта, который переопределен
        oos.writeObject(withStatic);
        oos.flush();
        oos.close();

        // меняем статичное поле класса
        ClassWithStatic.staticString = "++++++++++";

        // созаем потоки чтения объекта из файла
        InputStream inputStream = new FileInputStream(objectFile);
        ObjectInputStream ois = new ObjectInputStream(inputStream);

        // создаем новый объект класса
//        ClassWithStatic afterSerialization = new ClassWithStatic(1, 1);
//        System.out.println(ClassWithStatic.staticString); // "++++++++++"
//        System.out.println(afterSerialization.i); // 1
//        System.out.println(afterSerialization.j); // 1

        // теперь в созданный объект класса десериализуем существующий объект
        ClassWithStatic afterSerialization = (ClassWithStatic) ois.readObject();
        ois.close();

        // и поля нового объекта примут первоначальный вид
        System.out.println(ClassWithStatic.staticString); // "***********
        System.out.println(afterSerialization.i); // 10
        System.out.println(afterSerialization.j); // 99
    }
}
