package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        String tmp = Integer.toString(number); // преобразую число в строку
        int sum = 0; // переменная для суммирования чисел

        // цикл проходит по символам строки
        for (int i = 0; i < tmp.length(); i++) {
            // каждый символ строки преобразуется назад в целое число и прибавляется к sum
            sum += Character.getNumericValue(tmp.charAt(i));
        }
        return sum;
    }
}