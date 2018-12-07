package com.javarush.task.task14.task1419;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/*
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    // список для хранения объектов класса Exception
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        /// #01
        try {
            int num = Integer.parseInt("akki");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        /// #02
        File file = new File("fddv.gv");
        try {
            Scanner scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        /// #03
        try{
            String str1 = "fdgsbf";
            char ch = str1.charAt(50);
        }catch (StringIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        /// #03
        int[] arr = {12, 45, 0};
        try {
            int x = arr[4];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        /// #04
        String str = null;
        try {
            str.length();
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        /// #05
        double[] array0 = new double[2];
        try {
            array0[0] = 35f;
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        /// #06
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(0);
        list.add(45);
        try {
            list.get(3);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        /// #07
        try {
            int[] arry1 = new int[-5];
        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        /// #08
        try {
            int x = 60 / 0;
        } catch (ArithmeticException e) {
            exceptions.add(e);
        }
        /// #09
        try {
            LocalDate loc = LocalDate.of(5465, 545, 645);
        } catch (DateTimeException e) {
            exceptions.add(e);
        }
        /// #10
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            format.parse("54 df 45");
        } catch (ParseException e) {
            exceptions.add(e);
        }
    }
}
