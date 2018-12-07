package com.javarush.task.task06.task0617;

/* 
Блокнот для новых идей
*/

public class Solution {
    public static void main(String[] args) {
        printIdea(new Idea());
    }

    // есть класс идея
    public static class Idea {

        // в классе есть геттер возвращающий описание
        public String getDescription() {
            return "just test";
        }


    }

    // есть метод, который гетер выводит на печать
    public static void printIdea(Idea idea) {
        System.out.println(idea.getDescription());
    }
}
