package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new HashMap<>();

        while (inputStream.available() > 0) {
            int readB = inputStream.read();
            if (map.containsKey(readB)) {
                int val = map.get(readB) + 1;
                map.put(readB, val);
            } else {
                map.put(readB, 1);
            }
        }
        inputStream.close();

        Map.Entry<Integer, Integer> firstEntry = map.entrySet().iterator().next();
        int minValue = firstEntry.getValue();


        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            int curVal = pair.getValue();
            if (curVal < minValue) {
                minValue = curVal;
            }
        }

        String str = "";

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == minValue) {
                str = str + pair.getKey() + " ";
            }
        }

        str = str.trim();

        System.out.println(str);
//        System.out.println(map);



    }
}
