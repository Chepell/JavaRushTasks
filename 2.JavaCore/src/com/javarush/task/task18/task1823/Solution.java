package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле
максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать
    свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт
    в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        // поток чтения имен файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // строка для сохранения имени файла
        String fileName;

        // вечный цикл чтения имен
        while (true) {
            // читаю имя в переменную
            fileName = reader.readLine();
            // если прочитал exit то прерываю цикл
            if ("exit".equalsIgnoreCase(fileName)) break;
            // иначе вызываю конструктор объекта нити
            new ReadThread(fileName).start();
        }
        // если вышел из цикла, то закрываю поток чтения имен
        reader.close();

    }

    // класс наследник от Threads
    public static class ReadThread extends Thread {
        // полем идет имя файла
        private String fileName;

        // кунструктор, замена конструктора по умолчанию
        public ReadThread(String fileName) {
            this.fileName = fileName;
            // в конструкторе запускаю поток
        }

        // переопределиение метожа многонитьевости
        @Override
        public void run() {
            try {
                // открываю поток чтения из файла
                FileInputStream inputStream = new FileInputStream(fileName);
                // создаю TreeMap для хранения пар байт:количество повторов в файле
                Map<Integer, Integer> frequencyMap = new TreeMap<>();

                while (inputStream.available() > 0) {
                    // сохраняю прочитанный байт в переменную
                    int byteKey = inputStream.read();
                    // если мэп уже содержит такой байт
                    if (frequencyMap.containsKey(byteKey)) {
                        // итерирую value
                        int newValue = frequencyMap.get(byteKey) + 1;
                        // обновляю значение пары
                        frequencyMap.put(byteKey, newValue);
                    } else {
                        frequencyMap.put(byteKey, 1);
                    }
                }
                // вышел из цикла, значит файл кончился, закрываю поток
                inputStream.close();
                // теперь нужно найти в мэпе максимальный value
                int maxFreq = Collections.max(frequencyMap.values());
                // создаю переменную под байт key с максимальным количеством повторений
                int maxFreqByte = 0;
                // Циклом прохожу по мэпу
                for (Map.Entry<Integer, Integer> pair : frequencyMap.entrySet()) {
                    // если value найдено, то сохраняю ключ
                    if (maxFreq == pair.getValue()) maxFreqByte = pair.getKey();
                }
                // добавляю пару в мэп
                resultMap.put(fileName, maxFreqByte);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
