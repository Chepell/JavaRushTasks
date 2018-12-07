package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
6. Не используй статические переменные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        // создаю множество для сохранения имен файлов
        Set<String> fileParts = new TreeSet(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                Pattern p = Pattern.compile("^(.*part)(\\d+)$");

                Matcher ma = p.matcher(a);
                Matcher mb = p.matcher(b);

                if (ma.matches() && mb.matches()) {
                    if (ma.group(1).compareTo(mb.group(1)) == 0) {
                        Integer ai = Integer.parseInt(ma.group(2));
                        Integer bi = Integer.parseInt(mb.group(2));

                        return ai.compareTo(bi);
                    }
                }
                return a.compareTo(b);
            }
        });

        // буффер для чтения имен файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // объявление переменной для храниения считанного имени файла
        String fileName;

        // вечный цикл чтения имен файло
        while (true) {
            // считываю имя файла
            fileName = reader.readLine();
            // если введено end то прерываю цикл
            if ("end".equalsIgnoreCase(fileName)) break;
            // иначе сохраняю имена файлов в сортированное множество
            fileParts.add(fileName);
        }

        // сохраняю в переменную из множества первое имя файла
        String firstNameInSet = ((TreeSet<String>) fileParts).first();
        //


        // ищу в имени крайнюю правую точку, которая позволит отделить имя файла
        int indexOfLastDot = firstNameInSet.lastIndexOf(".");
        // образаю строку по индексу точки и получаю имя конечного файла
        String finalFileName = firstNameInSet.substring(0, indexOfLastDot);

        // создаю поток записи в файл с добавлением
        FileOutputStream outputStream = new FileOutputStream(finalFileName, true);
        // создаю буффер на 64Кб для чтеня/записи
        byte[] buffer = new byte[65536];

        // в цикле прохожусь но всем именам файлов в множестве
        for (String file : fileParts) {
            // создаю для конкретного файла поток
            FileInputStream inputStream = new FileInputStream(file);
            // читаю поток в буффер и сразу дописываю в поток конечного файла
            while (inputStream.available() > 0) {
                // каждый раз сохраняю количество считанных байт в счетчик
                int countByte = inputStream.read(buffer);
                // записываю из буффера в файл все байты
                outputStream.write(buffer, 0, countByte);
            }
            // перед окончанием петли цикла закрываю поток
            inputStream.close();
        }
        // выйдя из цикла записи, закрываю и соответствующий поток
        outputStream.close();
    }
}