package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму
    всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        // сохраняю в переменную параметр командной строки
        String fileName = args[0];

        // создаю сортированный мэп для хранения пар Фамилия - зарплата
        Map<String, Double> salaries = new TreeMap<>();

        // создаю объект чтения файла построчно
        BufferedReader readerFile = new BufferedReader(new FileReader(fileName));

        // создаю переменный чтения строки файла
        String strLine;
        // строка имени
        String name;
        // строка ЗП
        double salary;

        // циклом иду по строкам файла
        while (readerFile.ready()) {
            // читаю строку в файл
            strLine = readerFile.readLine();
            // проверяю, что строка не начинается с BOM символа
            // иначе удалаю его
            if (strLine.startsWith("\uFEFF")) strLine = strLine.substring(1);
            // с помощью регулярных выражений вытаскиваю из строки фамилию
            name = strLine.replaceAll("\\s.+", "");
            // так же вытаскиваю зарплату и прасю в дабл число
            salary = Double.parseDouble(strLine.replaceAll(".+\\s", ""));

            // теперь проверяю есть ли уже такой key в мэпе
            if (salaries.containsKey(name)) {
                // если есть, то обновляю значение зарплаты
                // к текущему полученному из строку значению прибавляю, то что есть в мэпе
                salary += salaries.get(name);
                // и добавляю пару в мэп, фактически перезаписывая существующую запись
                salaries.put(name, salary);
            } else {
                // если key отсутствует, то просто добавляю пару в мэп
                salaries.put(name, salary);
            }
        }
        // вышел из цикла чтения, закрываю поток
        readerFile.close();

        // вывожу пары на консоль
        for (Map.Entry<String, Double> pair : salaries.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        // вывод с помошью лямбда-выражения
        salaries.forEach((k, v) -> System.out.println(k + " " + v));
    }
}
