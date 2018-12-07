package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int array0[];    //declaring array
        array0 = new int[3];  // allocating memory to array

        int[] array = new int[3];

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int i = array.length - 1; i >=0; i--) {
            System.out.print(array[i] + " ");
        }



//        for(int i = 0; i < array.length / 2; i++)
//        {
//            int temp = array[i];
//            array[i] = array[array.length - i - 1];
//            array[array.length - i - 1] = temp;
//        }
//
//        System.out.println(Arrays.toString(array));



    }

}
