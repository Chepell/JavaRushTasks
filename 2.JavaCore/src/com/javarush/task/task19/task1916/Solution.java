package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
6. Программа должна считывать содержимое первого и второго файла (используй FileReader).
7. Потоки чтения из файлов (FileReader) должны быть закрыты.
8. Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // объект для чтения имен файлов
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // переменные для хранения имен файлов считанных с клавиатуры
        String nameFile1 = "01.txt";
        String nameFile2 = "02.txt";
//        String nameFile1 = reader.readLine();
//        String nameFile2 = reader.readLine();
        // имена считанны, закрываем поток
//        reader.close();

        // объекты для чтения строк файла
        BufferedReader readerFile1 = new BufferedReader(new FileReader(nameFile1));
        BufferedReader readerFile2 = new BufferedReader(new FileReader(nameFile2));

        List<String> list1tmp = new ArrayList<>();
        List<String> list2tmp = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (readerFile1.ready()) {
            String line = readerFile1.readLine().replace("\uFEFF", "");
            list1tmp.add(line);
        }

        while (readerFile2.ready()) {
            String line = readerFile2.readLine().replace("\uFEFF", "");
            list2tmp.add(line);
        }

        System.out.println(list1tmp);
        System.out.println(list2tmp);

        readerFile1.close();
        readerFile2.close();

        int maxCount = Math.max(list1tmp.size(), list2tmp.size());

        for (int i = 0; i < maxCount; i++) {
            String tmp1 = list1tmp.get(i);
            String tmp2 = list2tmp.get(i);

            if (tmp1.equals(tmp2)) {
                list1.add(tmp1);
                list2.add(tmp2);
            }



        }



//        String line1 = null;
//        String line2 = null;
//
//        if (readerFile1.ready()) line1 = readerFile1.readLine().replace("\uFEFF", "");
//        if (readerFile2.ready()) line2 = readerFile2.readLine().replace("\uFEFF", "");
//
//        String nextLine1 = null;
//        String nextLine2 = null;
//
//        while (line1 != null || line2 != null) {
//
//            if (line1 == line2) {
//                lines.add(new LineItem(Type.SAME, line1));
//                line1 = readerFile1.readLine().replace("\uFEFF", "");
//                line2 = readerFile2.readLine().replace("\uFEFF", "");
//            }
//
//            if (line1 != line2) {
//                nextLine1 = readerFile1.readLine();
//                nextLine2 = readerFile1.readLine();
//                if (line1 == nextLine2) {
//                    lines.add(new LineItem(Type.ADDED, nextLine2));
//                    line2 = nextLine2;
//                    nextLine2 = null;
//                }
//
//                if (nextLine1 == line2) {
//                    lines.add(new LineItem(Type.REMOVED, nextLine1));
//                    line1 = nextLine1;
//                    nextLine1 = null;
//                }
//            }
//        }


//        System.out.println(lines.toArray());


    }


    // перечисление того что произошло со строкой
    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    // класс для хранения того что произошло со строкой и самой строки
    public static class LineItem {
        // поля класса
        public Type type;
        public String line;

        // конструктор класса
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
