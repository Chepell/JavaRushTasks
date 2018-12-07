package com.javarush.task.task30.task3009;

/*
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []

    }

    private static Set<Integer> getRadix(String number) {
        // создаю сэт под результаты
        Set<Integer> resultSet = new HashSet<>();

        try {
            // конвертирую строку в число
            int num = Integer.parseInt(number);
            // циклом иду по всем возможным основаниям чисел с 2 до 36
            for (int i = Character.MIN_RADIX; i <= Character.MAX_RADIX; i++) {
                // конвертирую число в строковое представление числа с основанием i
                String string = Integer.toUnsignedString(num, i);
                // создаю из строки стринг билдер, разворачиваю строку и опять конвертирую в обычную строку
                String reverseString = new StringBuilder(string).reverse().toString();
                // и если обычная строка равна перевернутой, то это палиндром
                if (string.equals(reverseString)) {
                    resultSet.add(i); // добавляю основание в мэп
                }
            }
        } catch (NumberFormatException e) {

        }
        return resultSet;
    }
}

//Палиндром?
//Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number),
// в котором нужно определить, в каких системах счисления (от 2 до 36 включительно)
// представление числа number (передается в десятичной системе счисления) является палиндромом
// и добавить индекс таких систем в результат.
//Если переданное число некорректно - возвращай пустой HashSet.
//В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы.
// К примеру, числу 35 в десятичной системе соответствует число "Z" в системе с основанием 36.
//
//Метод main не принимает участие в тестировании.
//
//P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно.
//
//
//Требования:
//1. Необходимо объявить приватный статический метод Set getRadix(String number).
//2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
//3. Методе getRadix не должен бросать NumberFormatException.
//4. Метод getRadix не должен ничего выводить в консоль.
//5. Метод getRadix должен возвращать множество согласно условию задачи.