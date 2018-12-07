package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправь ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.

Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные - writeObject
3) сериализовать класс Solution - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5


Требования:
1. Поле stream должно быть объявлено с модификатором transient.
2. В методе writeObject(ObjectOutputStream out) не должен быть
    вызван метод close у потока полученного в качестве параметра.
3. В методе readObject(ObjectInputStream in) не должен быть вызван
    метод close у потока полученного в качестве параметра.
4. В методе readObject(ObjectInputStream in) поле stream должно быть
    инициализировано новым объектом типа FileOutputStream с параметрами(fileName, true).
5. В конструкторе класса Solution поле stream должно быть инициализировано
    новым объектом типа FileOutputStream с параметром(fileName).
*/
public class Solution implements Serializable, AutoCloseable {
    // в классе поле поток записи в файл
    // его нужно делать transient, т.к. потоки не сериализуются
    private transient FileOutputStream stream;
    private String fileName;

    // конструктор принимающий параметром имя файла
    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        // и инициируется поле класса
        this.stream = new FileOutputStream(this.fileName);
    }

    // объект для записи строки в файл
    public void writeObject(String string) throws IOException {
        // пишется строка
        stream.write(string.getBytes());
        // добавляется символ новой строки
        stream.write("\n".getBytes());
        // принудительная запись
        stream.flush();
    }

    // методы записи/чтения
    private void writeObject(ObjectOutputStream out) throws IOException {
        // стандартная сериализация всего объекта
        out.defaultWriteObject();
        // сохраняю отдельным объектом имя файла
        out.writeObject(fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        // стандартное восстановление всего объекта
        in.defaultReadObject();
        // восстанавливаю имя файла
//        fileName = (String) in.readObject();
        // восстанавливаю по имени файла поток
        this.stream = new FileOutputStream(fileName,true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {

//        Solution sol = new Solution("solFile.txt");
//        sol.writeObject("hello");
//        sol.close();
//
//        OutputStream outputStream = new FileOutputStream("solSerilization.txt");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(sol);
//
//
//        InputStream inputStream = new FileInputStream("solSerilization.txt");
//        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//        Solution solNew = (Solution) objectInputStream.readObject();
//        solNew.writeObject("Hello2");
    }
}
