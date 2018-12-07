package com.javarush.task.task19.task1920;

/* 
Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль имена, у которых максимальная сумма.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];

        BufferedReader readFile = new BufferedReader(new FileReader(fileName));

        Map<String, Double> salaries = new TreeMap<>();

        String stringLine;
        String name;
        double salary;
        while (readFile.ready()) {
            stringLine = readFile.readLine();
            stringLine = stringLine.replace("\uFEFF", "");
            String[] strArr = stringLine.split(" ");
            name = strArr[0];
            salary = Double.parseDouble(strArr[1]);
            if (salaries.containsKey(name)) {
                salary += salaries.get(name);
                salaries.put(name, salary);
            } else {
                salaries.put(name, salary);
            }
        }
        readFile.close();

        // переменная под максимальную ЗП в мэпе
        double maxSalary = 0;
        for (Map.Entry<String, Double> pair : salaries.entrySet()) {
            if (pair.getValue() > maxSalary) {
                maxSalary = pair.getValue();
            }
        }

        // список для самых богатых господ, если их несколько
        List<String> names = new ArrayList<>();

        // циклом иду по мэпу и у кого ЗП равна максимальной добавляю в список
        for (Map.Entry<String, Double> pair : salaries.entrySet()) {
            if (pair.getValue() == maxSalary) {
                names.add(pair.getKey());
            }
        }

        // вывожу на экран
        for (String n : names) {
            System.out.println(n);
        }
    }
}
