package com.javarush.task.task10.task1011;

/* 
Большая зарплата

Требования:
1. Программа должна выводить текст на экран.
2. Программа должна выводить 40 строк.
3. В программе должен использоваться цикл for или while.
4. Выведенный текст должен соответствовать примеру из условия.
*/

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";

        for (int i = 0; i < 40; i++) {
            String cutString = s.substring(i);
            System.out.println(cutString);
        }

    }

}

