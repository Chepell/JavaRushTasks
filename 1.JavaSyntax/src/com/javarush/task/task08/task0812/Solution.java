package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Cамая длинная последовательность
*/

// Программа должна выводить число на экран.

// Программа должна выводить на экран длину самой длинной последовательности повторяющихся чисел в списке.
public class Solution {
    public static void main(String[] args) throws IOException {
        // В методе main объяви переменную типа ArrayList с типом элементов Integer и сразу проинициализируй ee.
        ArrayList<Integer> list = new ArrayList<>();

        // Программа должна считывать значения с клавиатуры.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Программа должна добавлять в коллекцию 10 чисел, согласно условию.
        for (int i = 0; i < 10; i++) {
            int x = Integer.parseInt(reader.readLine());
            list.add(x);
        }

////// МОЯ ПЕРВАЯ РЕАЛИЗАЦИЯ //////
//        // счетчик количества повторений цифр
//        Integer counter = 1;
//        // список под каждую из серий повторений
//        List<Integer> countList = new ArrayList<>();
//
//        // проход начинаю со второго элемента
//        for (int i = 1; i < list.size(); ++i) {
//            // тут начинаю сравнение второго элемента с первым
//            if (list.get(i).equals(list.get(i - 1))) {
//                // считаю количество повторений цифр
//                counter++;
//            }
//            // если серия прервалась
//            if (!list.get(i).equals(list.get(i - 1))) {
//                // сохраняю значение счетчика в лист
//                countList.add(counter);
//                // сбрасываю счетчик
//                counter = 1;
//            } // когда дошли до конца списка, нужно счетчик в любом случае сохранить в список
//            if (i == 9) {
//                // сохраняю значение в лист
//                countList.add(counter);
//            }
//        }
//
//        // поиск максимума в списке вручную
//        int max_count = Integer.MIN_VALUE;
//        for (Integer i : count) {
//            if (i > max_count) {
//                max_count = i;
//            }
//        }
//
//        // поиск максимума с помощью встроенного метода
//        int max_count = Collections.max(countList);
//
//        System.out.println(max_count);

        int tmp = 1;
        int count = 1;
        // проход начинаю со второго элемента
        for (int i = 1; i < list.size(); i++) {
            // тут начинаю сравнение второго элемента с первым
            // объекты не могу сравнивать нвпрямую
            //if (list.get(i).equals(list.get(i - 1))) {
            if ((int)list.get(i) == (int)list.get(i - 1)) {
                // инкрементирую счетчик
                tmp++;
                // если счетчик больше tmp, то сохраняю туда значение
                if (tmp > count) {
                    count = tmp;
                }
            } else {
                tmp = 1;
            }
        }


        System.out.println(count);
    }
}