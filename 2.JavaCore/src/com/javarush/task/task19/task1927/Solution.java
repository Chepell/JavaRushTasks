package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на
консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString
    типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран
    строки: "first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток
    PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и
    восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять
    контекстную рекламу) выведенные методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //сохраняю стандартный поток вывода
        PrintStream stdnOut = System.out;
        // создаю массив для сохранения своего потока
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        // создаю свой поток вывода
        PrintStream myOut = new PrintStream(arrayOutputStream);
        // подменяю поток
        System.setOut(myOut);
        // вызываю метод на объекте
        testString.printSomething();
        // меняю поток на стандартный
        System.setOut(stdnOut);
        // массив в который производился вывод конвертирую в строку
        // далее строку по символу переноса режу и помещаю в массив строк
        String[] lines = arrayOutputStream.toString().split(System.lineSeparator());

        // циклом иду массиву
        for (int i = 0; i < lines.length; i++) {
            // каждые две итерации, кроме первой, вывожу на экран строку рекламы
            if (i != 0 && i % 2 == 0) {
                System.out.println("JavaRush - курсы Java онлайн");
            }
            // и вывожу все поля массива
            System.out.println(lines[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
