package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Самая длинная строка
*/

public class Solution {
    private static List<String> strings;

    public static void main(String[] args) throws Exception {
        // Инициализируй существующее поле strings класса Solution новым ArrayList<>
        strings = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Программа должна считывать 5 строк с клавиатуры и записывать их в список strings.
        for (int i = 0; i < 5; i++) {
            strings.add(br.readLine());
        }

        // Программа должна выводить самую длинную строку на экран.
        // Если есть несколько строк с длиной равной максимальной, то нужно вывести каждую из них с новой строки.

        // переменная под максимальную строку, по умолчанию первая в списке
        String maxString = strings.get(0);
        // переменная под втрую стоку, если будет найдена такая же.
        String secondMax = "";

        // в цикле проходим по всем элементам списка начиная со второго
        for (int i = 1; i < strings.size() ; i++) {
            // если длина строки в текущем положении списка больше чем в перменной
            if ((strings.get(i)).length() > maxString.length()) {
                // то обновляю переменную и втрую строку сбрасываю в null
                maxString = strings.get(i);
                secondMax = "";
                // если же текущая строка равна по длине сохраненной, то копирую ее в переменную для второй строки
            } else if ((strings.get(i)).length() == maxString.length()) {
                secondMax = strings.get(i);
            }

        }

        // если вторая строка пустая, то печатаю только первую
        if (secondMax == null) {
            System.out.println(maxString);
        } else { // иначе печатаю обе строки
            System.out.println(maxString);
            System.out.println(secondMax);
        }






    }
}
