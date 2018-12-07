package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // реализация через try-with-resources, инициирую буферы, а потом они сами закроются
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()))) {

            // объект для сохранения строки
            StringBuilder sb = new StringBuilder();
            // переменная для чтения в нее текущей строки
            String line;
            // циклом иду по файлу пока строки есть
            while (fileRead.ready()) {
                // читаю строку и сразу проверяю на byte order mark и удаляю если есть
                line = fileRead.readLine().replace("\uFEFF", "");
                // добавляю считанную строку в объект и после нее еще пробел, что бы строки не склеивались
                sb.append(line).append(" ");
            }

            // Объект StringBuilder конвертирую в строку и методом trim
            // удаляю лишние пробелы по краям, слева точно будет пробел изза добавления в цикле
            String strFromSb = sb.toString().trim();
            // Строку режу по пробелам в массив строк
            String[] arrStr = strFromSb.split(" ");
            // массив конвертирую в список
            List<String> list = new ArrayList<>(Arrays.asList(arrStr));

            // циклом иду по списку пока есть элементы
            while (list.size() != 0) {
                // удаляю первый элемент из списка сохранив его в переменную
                String strRemove = list.remove(0);
                // делаю зеркальную копию удаленного элемента через StringBuilder
                // и сразу назад конвертирую в строку
                String strReverse = new StringBuilder(strRemove).reverse().toString();
                // циклом иду по всем элементам уже нового списка без удаленного элемента
                for (int i = 0; i < list.size(); i++) {
                    // сравниваю текущий элемент с зеркальным
                    if (list.get(i).equals(strReverse)) {
                        // если они равны то в список добавляю новый объект класса Pair
                        // первым элементом идет удаленный в самом начале первый элемент списка
                        // а вторым элементом удаляю и созраняю текущий элемент списка
                        result.add(new Pair());
                        int resultLen = result.size() - 1;
                        result.get(resultLen).first = strRemove;
                        result.get(resultLen).second = list.remove(i);
                        // и т.к. пара найдена и было удаление элемента, то прерываю цикл for
                        // возвращаюсь в начало цикла while
                        break;
                    }
                }
            }
        }

//        result.forEach(System.out::println);

    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null && second != null ? second :
                            second == null && first != null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
