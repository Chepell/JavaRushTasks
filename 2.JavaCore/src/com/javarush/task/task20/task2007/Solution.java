package com.javarush.task.task20.task2007;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JavaRush?
Сделай так, чтобы сериализация класса JavaRush была возможной.


Требования:
1. Класс JavaRush должен существовать внутри класса Solution.
2. Класс JavaRush должен быть статическим.
3. Класс JavaRush должен быть публичным.
4. Класс JavaRush должен поддерживать интерфейс Serializable.
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        JavaRush javaRush = new JavaRush();

        OutputStream outputStream = new FileOutputStream("testSer.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(javaRush);
        objectOutputStream.flush();
        objectOutputStream.close();
        outputStream.close();


        InputStream inputStream = new FileInputStream("testSer.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        JavaRush newObj = new JavaRush();

        newObj = (JavaRush) objectInputStream.readObject();

    }


}
