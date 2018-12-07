package com.javarush.task.task06.task0606;

import java.io.*;
import java.util.Scanner;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        // объект для ввода с клавиатуры
        Scanner sc = new Scanner(System.in);
        // строка под ввод
        String str = sc.nextLine();

        // итерирую строку по длине получая символы
        for (int i = 0; i < str.length(); i++) {
            // переменная под каждый символ c приведением типов к числу
            int num = (int)str.charAt(i);
            // проверка символа и обновление счетчиков
            if (num % 2 == 0) { // если число четное
                even++;
            } else { // если же число не четное
                odd++;
            }
        }
        System.out.printf("Even: %d Odd: %d", even, odd);
    }
}
