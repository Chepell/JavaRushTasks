package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        // создаю поток чтения файла
        FileInputStream inputStream = new FileInputStream(args[0]);

        // создаю мэп который сазу сортирует пары по ключам
        Map<Character, Integer> frequencyMap = new TreeMap<>();

        // переменная для чтения байта из файла и конвертации его в символ
        char readByte;
        // чтение файла побайтово пока он не кончится
        while (inputStream.available() > 0) {
            // явное приведение типа к char, т.к. по умолчанию читается int
            readByte = (char) inputStream.read();

            // такой символ уже есть
            if (frequencyMap.containsKey(readByte)) {
                // достаю значение value и итерирую его
                int newValue = frequencyMap.get(readByte) + 1;
                // помещаю пару в мэп, фактически перезаписывается старая пара
                frequencyMap.put(readByte, newValue);
            } else {
                // иначе добавляю пару в мэп, пока только один раз повторилось значение
                frequencyMap.put(readByte, 1);
            }
        }
        // вышел из цикла, файл прочитал, закрываю поток
        inputStream.close();

        // в цикле достаю значения и вывожу на печать
        for (Map.Entry<Character, Integer> pair : frequencyMap.entrySet()) {
            Character key = pair.getKey();
            Integer value = pair.getValue();
            System.out.println(key + " " + value);
        }
    }
}
