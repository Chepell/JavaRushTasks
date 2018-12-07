package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Задача по алгоритмам
 * Задача: Пользователь вводит с клавиатуры список слов (и чисел).
 * Слова вывести в возрастающем порядке, числа - в убывающем.
 * <p>
 * Пример ввода:
 * Вишня
 * 1
 * Боб
 * 3
 * Яблоко
 * 22
 * 0
 * Арбуз
 * <p>
 * Пример вывода:
 * Арбуз
 * 22
 * Боб
 * 3
 * Вишня
 * 1
 * 0
 * Яблоко
 * <p>
 * <p>
 * Требования:
 * 1. Программа должна считывать данные с клавиатуры.
 * 2. Программа должна выводить данные на экран.
 * 3. Выведенные слова должны быть упорядочены по возрастанию (используй готовый метод isGreaterThan).
 * 4. Выведенные числа должны быть упорядочены по убыванию.
 * 5. Метод main должен использовать метод sort.
 * 6. Метод sort должен использовать метод isGreaterThan.
 * 7. Метод sort должен использовать метод isNumber.
 */

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // создаю список строк
        ArrayList<String> list = new ArrayList<>();
        // вечный цикл ввода строки
        while (true) {
            String s = reader.readLine();
            // прерывается если пустая строка
            if (s.isEmpty()) break;
            // все что ввели добавляется в лист
            list.add(s);
        }
        // создаю теперь массив строк, т.к. знаю длину массива
        // и список конвертирую в массив
        String[] array = list.toArray(new String[list.size()]);

        //String[] array = {"Вишня", "1", "Бор", "3", "Яблоко", "22", "0", "Арбуз", "Боб", "Война"};

        // метод сортировки массива
        sort(array);

        // вывод результатов на экран
        for (String x : array) {
            System.out.println(x);
        }
    }


    // метод сортировки массива по заданным критериям
    public static void sort(String[] array) {
        // длина исходного общего массива
        int len = array.length;

        // список индексов массива, где должны находиться числа
        List<Integer> listNumInd = new ArrayList<>();
        // список индексов массива, где должны находиться строки
        List<Integer> listStrInd = new ArrayList<>();

        // список всех цифр найденных в массиве,
        List<Integer> listNum = new ArrayList<>();
        // список всех строк найденных в массиве
        List<String> listStr = new ArrayList<>();

        // цикл по исходному общему массиву
        for (int i = 0; i < len; i++) {
            // если нашел цифру
            if (isNumber(array[i])) {
                // сохраняю индекс цифры
                listNumInd.add(i);
                // сохраняю саму цифру
                listNum.add(Integer.parseInt(array[i]));
            } else {
                // сохраняю индекс строки
                listStrInd.add(i);
                // сохраняю саму цифру
                listStr.add(array[i]);
            }
        }

        // сортирую разделенные коллекции цифр и строк
        Collections.sort(listNum);
        Collections.sort(listStr);

        // создаю массивы из отсортированных списков
        Integer[] arrNumInd = listNumInd.toArray(new Integer[listNumInd.size()]);
        Integer[] arrStrInd = listStrInd.toArray(new Integer[listStr.size()]);

        Integer[] arrNum = listNum.toArray(new Integer[listNum.size()]);
        String[] arrStr = listStr.toArray(new String[listStr.size()]);

//        // прохожу циклом по остортированному массиву цифр
//        for (int i = 0; i < arrNum.length; i++) {
//            // конвертирую каждый Integer в массиве в строку,
//            // что бы вставить на нужную позицию исходного массива
//            // причем надо вставлять задом на перед
//            String strVal = arrNum[arrNum.length - 1 - i].toString();
//            // беру из массива с индексами нужный индекс цисла
//            int index = arrNumInd[i];
//            // в исходном массиве перезаписываю на месте index значение strVal
//            array[index] = strVal;
//        }

        // прохожу циклом по остортированному массиву цифр
        for (int i = arrNum.length - 1; i >= 0; i--) {
            // конвертирую каждый Integer в массиве в строку,
            // что бы вставить на нужную позицию исходного массива
            // причем надо вставлять задом на перед
            String strVal = arrNum[i].toString();
            // беру из массива с индексами нужный индекс цисла
            int index = arrNumInd[i];
            // в исходном массиве перезаписываю на месте index значение strVal
            array[index] = strVal;
        }

        // прохожу циклом по остортированному массиву строк
        for (int i = 0; i < arrStr.length; i++) {
            // сохраняю значение в строку
            String strVal = arrStr[i];
            // беру из массива с индексами нужный индекс цисла
            int index = arrStrInd[i];
            // в исходном массиве перезаписываю на месте index значение strVal
            array[index] = strVal;
        }

        isGreaterThan("Бор", "Боб");
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        // проверяю что строка не пустая
        if (s.length() == 0) return false;
        // конвертирую строку в массив символов
        char[] chars = s.toCharArray();
        // циклом иду по массиву символов
        for (int i = 0; i < chars.length; i++) {
            // достаю каждый символ в переменную
            char c = chars[i];
            // ищу признаки характеризующие строку
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') // не цифра и не начинается с '-'
                    || (i == 0 && c == '-' && chars.length == 1)) // не '-'
            {
                return false;
            }
        }
        // если дошел сюда, возвращаю
        return true;
    }
}
