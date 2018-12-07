package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить только цифры.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.

Пример вывода:
12345678


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString
    типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на
    экран строку "it's 1 a 23 text 4 f5-6or7 tes8ting".
5. Метод main(String[] args) класса Solution должен создавать поток
    PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и
    восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать
    метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать
    строку выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // сохраняю стандартный поток вывода
        PrintStream standartOut = System.out;
        // создаю массив для сохранения потока
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        // создаю свой поток вывода в массив
        PrintStream myOut = new PrintStream(arrayOutputStream);
        // меняю поток на свой
        System.setOut(myOut);
        // вызываю метод на объекте
        testString.printSomething();
        // меняю поток на стандартный
        System.setOut(standartOut);
        // Сохраняю в строку, то что вывелось в байтовый массив
        String string = arrayOutputStream.toString().replaceAll("\\D", "");
        // вывожу видоизмененую строку на экран
        System.out.println(string); // вывод на экран 12345678
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
