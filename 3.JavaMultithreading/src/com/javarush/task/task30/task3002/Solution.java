package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        int i;
        if (s.startsWith("0x")) { // 16ти ричное число
            // 0х16 = 1 * 16^1 + 6 * 16^0 = 16 + 6 = 22
            s = s.substring(2);
            i = Integer.parseInt(s, 16);
        } else if (s.startsWith("0b")) { // двоичное число
            // 0b10 = 1 * 2^1 + 0 * 2^0 = 2 + 0 = 2
            s = s.substring(2);
            i = Integer.parseInt(s, 2);
        } else if (s.startsWith("0") && s.length() > 1) { // 8ми ричное число
            // 012 = 1 * 8^1 + 2 * 8^0 = 8 + 2 = 10
            s = s.substring(1);
            i = Integer.parseInt(s, 8);
        } else { // десятичное число
            i = Integer.parseInt(s, 10);
        }
        return i + "";
    }
}
//Осваиваем методы класса Integer
//Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem,
// который должен переводить переданную строку в десятичное число и возвращать его в виде строки.