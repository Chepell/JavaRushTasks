package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
Ввести с клавиатуры в список 20 слов.
Нужно подсчитать сколько раз каждое слово встречается в списке.
Результат нужно представить в виде словаря Map<String, Integer>,
где первый параметр - уникальное слово, а второй - число,
сколько раз данное слово встречалось в списке.

Вывести содержимое словаря на экран.
В тестах регистр (большая/маленькая буква) влияет на результат.


Требования:
1. Метод countWords должен объявлять и инициализировать HashMap с типом элементов .
2. Метод countWords должен возвращать созданный словарь.
3. Метод countWords должен добавлять в словарь ключи,
соответствующие уникальным словам, и значения по этим ключам,
отображающие сколько раз встречалось слово.
4. Программа должна выводить на экран полученный словарь.
5. Метод main должен вызывать метод countWords.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // объект для чтения строки с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // список для ввода 20ти слов с клавиатуры
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        // создание мэпа с результатами расчета частотности слов с момщью метода
        Map<String, Integer> map = countWords(words);

        // вывод мэпа на экран
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    // имплементация метода
    public static Map<String, Integer> countWords(ArrayList<String> list) {
        // обяъвление и инициализация переменной типа хэшмэп
        HashMap<String, Integer> result = new HashMap<>();

        // вшений цикл по списку, фиксируюсь на одном элементе
        // и дальше внутренним циклом прохожу по списку опять и
        // считаю количество повторений этого элемента
        for (String str : list) {
            // счетчик слов начинаю с нуля
            // т.к. во внтуреннем цикле прохожу по всему списку
            // то в какой-то момент один и тот же элемент буду сравнивать и будет 1
            int counter = 0;
            for (String s : list) {
                if (str.equals(s)) {
                    counter++;
                }
            }
            // после окончания внутреннего цикла каждый раз скидываю данные в мэп
            // т.к. в мэпе key должны быть уникальными, то решается проблема повторов слов в списке
            result.put(str, counter);
        }
        // метод возвращает наполненный мэп
        return result;
    }

}

