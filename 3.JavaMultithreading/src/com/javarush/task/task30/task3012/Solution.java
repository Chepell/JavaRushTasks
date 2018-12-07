package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(66);
    }

    public void createExpression(int number) {
        String numAndEqual = String.format("%d =", number);
        StringBuilder result = new StringBuilder(numAndEqual);
        // варианты форматирования. пусто, с плюсом, с минусом
        String[] formats = {"", " + %d", " - %d"};

        int tri = 1; // троичные числа начинаются с 1
        for (int i = number; i > 0; i = ++i / 3) {
            String str = String.format(formats[i % 3], tri);
            result.append(str);
            tri *= 3; // итератор серии троичных чисел. 1 - 3 - 9 - 27 - 81 - 243 - 729 - 2187
        }
        System.out.println(result);

    }
}