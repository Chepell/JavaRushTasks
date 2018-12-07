package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        Map<Integer, Integer> byteMap = new HashMap<>();
        FileInputStream inputStream = new FileInputStream(fileName);

        // цикл продолжается пока есть байты в файле
        while (inputStream.available() > 0) {
            // записываю текущий считанный байт в переменную
            int readByte = inputStream.read();
            // проверяю есть ли уже такой ключ в мэпе
            if (byteMap.containsKey(readByte)) {
                // если есть, то беру из мэпа текущее значение value и инкрементирую
                int value = byteMap.get(readByte) + 1;
                // помещаю текущую запись в мэп, фактически будет перезаписана существующая запись
                byteMap.put(readByte, value);
            } else {
                // если же ключь не был найден, то добавляю его в мэп
                byteMap.put(readByte, 1);
            }
        }
        inputStream.close();

        // получаю первое Value из map c помощью iterator
        Map.Entry<Integer, Integer> firstEntry = byteMap.entrySet().iterator().next();
        int largestKeyValue = firstEntry.getValue();

        // циклом прохожу и ищу значение Value больше чем предыдущее
        for (Map.Entry<Integer, Integer> pair : byteMap.entrySet()) {
            // считываю значение в переменную
            int value = pair.getValue();
            // если значение больше чем в переменной
            if (value > largestKeyValue) {
                // то обновляю его
                largestKeyValue = pair.getValue();
            }
        }

        // строка для всех байт которые повторяются чаще всего, если их несолько
        String str = "";

        // циклом прохожу по мэпу
        for (Map.Entry<Integer, Integer> pair : byteMap.entrySet()) {
            // если текущее value равно максимальному
            if (pair.getValue() == largestKeyValue) {
                // то добавляю ключ в строку и добавляю пробел
                str = str + pair.getKey() + " ";
            }
        }

        // подрезаю лишний пробел в конце
        str = str.trim();

        // печатаю значения
        System.out.println(str);
    }
}
