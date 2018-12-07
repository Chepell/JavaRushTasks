package com.javarush.task.task19.task1915;

/* 
Дублируем текст
Считай с консоли имя файла.
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить весь текст и на консоль и в файл, имя которого ты считал.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.
Закрой поток файла.

Пример вывода на экран:
it's a text for testing

Пример тела файла:
it's a text for testing


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString
    типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "it's a text for testing".
5. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
6. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
7. Метод main(String[] args) класса Solution должен создавать поток PrintStream
    (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
8. Метод main(String[] args) класса Solution должен подменять и
    восстанавливать поток вывода в консоль объекта System.out.
9. Метод main(String[] args) класса Solution должен один раз вызвать
    метод printSomething() объекта testString.
10. Метод main(String[] args) класса Solution должен выводить и в консоль
    и в файл строку выведенную методом printSomething() (используй FileOutputStream).
11. Поток записи в файл (FileOutputStream) должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        // объект для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileOutput = reader.readLine();
        reader.close();

        // сохраняю стандартный поток вывода в переменную
        PrintStream stdOut = System.out;
        // создаю байтовый массив для собственного потока вывода
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        // создаю свой поток вывода
        PrintStream myOut = new PrintStream(arrayOutputStream);
        // меняю поток вывода
        System.setOut(myOut);
        // вызываю метод на объекте
        testString.printSomething();
        // меняю поток на стандартный
        System.setOut(stdOut);
        // создаю объект побайтовой записи в файл
        FileOutputStream outputStream = new FileOutputStream(fileOutput);
        // массив преобразую в байтовый массив для запии в файл
        outputStream.write(arrayOutputStream.toByteArray());
        // закрываю поток
        outputStream.close();
        // вывожу на экран
        System.out.println(arrayOutputStream);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

