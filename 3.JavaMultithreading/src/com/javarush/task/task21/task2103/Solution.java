package com.javarush.task.task21.task2103;

/* 
Все гениальное - просто!
*/
public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
//        return (a && b && c && !d) || (!a && c) || (!b && c) || (c && d);
        // c есть везде, а остальные меняются на противоположные от варианта к варианту
        // т.е. никак не влияют на самом деле
        // в первом a а во втром !a можно убрать оба
        // в первом b  а в третьем !b, опять убираю оба
        // в первом !d а в третьем d, убираю и остаются
        // return (c) || (c) || (c) || (c); сокращаю просто до с
        return c;
    }

    public static void main(String[] args) {

    }
}
