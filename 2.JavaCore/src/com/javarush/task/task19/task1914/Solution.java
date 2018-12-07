package com.javarush.task.task19.task1914;

/* 
Решаем пример
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить на консоль решенный пример.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString
    типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строку "3 + 6 = ".
5. Метод main(String[] args) класса Solution должен создавать поток
    PrintStream (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять
    и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод
    printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку
    выведенную методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // сохраняю стандартный поток вывода в переменную
        PrintStream stdOut = System.out;
        // создаю байтовый массив для создания своего потока вывода
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        // создаю свой поток вывода
        PrintStream myOut = new PrintStream(arrayOutputStream);
        // подменяю стандартный поток
        System.setOut(myOut);
        // вызываю метод на объекте
        testString.printSomething();
        //возвращаю поток вывода на стандартный
        System.setOut(stdOut);
        // сохраняю в строку даныне считанные в массив
        String string = arrayOutputStream.toString();
        // удаляю из строки существующие управляющие символы
        string = string.replace("\r\n", "");

        // создаю паттерн, с помощью которого группами буду символы разделять
        Pattern math = Pattern.compile("(\\d+)\\s(\\W)\\s(\\d+)\\s=.+");
        // на основе паттерна создается матчер
        Matcher matcher = math.matcher(string);

        int firstArg = 0;
        int secondArg = 0;
        int mathResult = 0;
        String sign = "";

        // ищу соответствия в цикле
        while (matcher.find()) {
            // с помощью групп выделяю нужные операторы
            firstArg = Integer.parseInt(matcher.group(1));
            secondArg = Integer.parseInt(matcher.group(3));
            sign = matcher.group(2);
        }

        // сумма
        if (sign.matches("\\+")) {
            mathResult = firstArg + secondArg;
            // произведение
        } else if (sign.matches("\\*")) {
            mathResult = firstArg * secondArg;
            // разность
        } else if (sign.matches("-")) {
            mathResult = firstArg - secondArg;
        }

        // вывожу строку + результат на экран
        System.out.println(string + mathResult);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

