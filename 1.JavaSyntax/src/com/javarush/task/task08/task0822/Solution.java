package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* 
Минимальное из N чисел
*/

// Программа должна выводить текст на экран.
// Программа должна считывать значения с клавиатуры.
// Класс Solution должен содержать только три метода.
// Метод main() должен вызывать метод getIntegerList().
// Метод main() должен вызывать метод getMinimum().
public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

//    // Метод getMinimum() должен вернуть минимальное число среди элементов списка.
//    public static int getMinimum(List<Integer> array) {
//        // объявляю переменную для хранения минимального значения в сприске
//        // и инициирую ее максимальным значением для числе int
//        // т.е. в любом слчаем минимум будет меньше этого значения
//        int min = Integer.MAX_VALUE;
//        // циклом foreach прохожу по элементам списка
//        for (Integer i: array) {
//            // тернарный оператор проверяет не меньше ли текущий элемент значения min
//            // если меньше, то обноляю его значение на текущее
//            min = i < min ? i : min;
//        }
//        // возвращаю значение переменной после цикла прохода по всем элементам
//        return min;
//    }

    // Метод getMinimum() должен вернуть минимальное число среди элементов списка.
    public static int getMinimum(List<Integer> array) {
        int min = Collections.min(array);
        return min;
    }

    // Метод getIntegerList() должен считать с клавиатуры число N,
    // потом вернуть список размером N элементов, заполненный числами с клавиатуры.
    public static List<Integer> getIntegerList() throws IOException {
        // обявляю объект класса для чтения данных и указываю ему читать из стандартного системного ввода
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // считываю в переменную количество элементов
        int n = Integer.parseInt(reader.readLine());
        // создаю список по числла
        List<Integer> list = new ArrayList<>();
        // создаю цикл наполнения списка
        for (int i = 0; i < n; i++) {
            // переменная для считывания чисел
            int x = Integer.parseInt(reader.readLine());
            // добавление считанного числа в конец списка
            list.add(x);
        }
        // метод возвращает созданный список
        return list;
    }
}
