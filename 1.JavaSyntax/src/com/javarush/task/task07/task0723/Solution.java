package com.javarush.task.task07.task0723;

/* 
Обратный отсчёт
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {

        for (int i = 30; i >= 0; i--) {
            System.out.println(i);

            // Программа не должна считывать данные с клавиатуры.
            // Программа должна выводить обратный отсчет от 30 до 0. Каждую цифру на новой строке.
            // Программа должна выводить "Бум!" после отсчета.
            // Программа должна использовать метод "Thread.sleep(100);" 31 раз.
            Thread.sleep(100);
        }
        System.out.println("Бум!");
    }
}
