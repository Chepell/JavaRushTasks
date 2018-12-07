package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // экзмляр класса буфера для чтения строки
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // обьявление переменной для хранения максимума, выставляю минимально возможное значение в int
        int maximum = Integer.MIN_VALUE;
        // считываю количество цифр которые будут введены с клавиатуры
        int n = Integer.parseInt(reader.readLine());

        // цикл для ввода нужного количества символов
        while (n > 0) {
            // переменная для хранения текущего ввода
            int tmp = Integer.parseInt(reader.readLine());
            // тернарное сравнение текущего значения maximum c введенным и обновление на большее
            maximum = tmp > maximum ? tmp : maximum;
            // счетчик проходов
            n--;
        }
        System.out.println(maximum);
    }
}
