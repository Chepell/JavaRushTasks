package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;

        System.out.println(Integer.toString(number, 2));
        // 1111111111111111111111101111010


        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
        // 1000000000000000000000000000000

    }

    public int resetLowerBits(int number) {
//        number |= number >> 1;
//        number |= number >> 2;
//        number |= number >> 4;
//        number &= ~number >> 1;
//        return number;


        return Integer.highestOneBit(number);
    }
}