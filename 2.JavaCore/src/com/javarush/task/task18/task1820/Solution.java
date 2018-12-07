package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // Буффер для чтения имен файлов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Сохраняю именя в переменные
        String file01 = reader.readLine();
        String file02 = reader.readLine();
        // закрываю буффер
        reader.close();
        // Поток для чтения из первого файла
        File readFile = new File(file01);
        // Буффер посимвольного чтения
        BufferedReader br = new BufferedReader(new FileReader(readFile));
        // читаю сроку из файла и сохраняю в переменную
        String string = br.readLine();
        // закрываю буффер
        br.close();
        // метод режет строку по пробелам и помещает все в массив строк
        String[] numbers = string.split(" ");
        // СОздаю объект типа построителя строк, для итоговой строки
        StringBuilder sb = new StringBuilder();
        // циклом прохожу по массиву строк
        for (int i = 0; i < numbers.length; i++) {
            // парсю строку в double
            double doubleNum = Double.parseDouble(numbers[i]);
            // округляю double соответствующим методом
            // делаю явное приведение типа к Int
            int intNum = (int) Math.round(doubleNum);
            // конвертирую в строку
            String strInt = String.valueOf(intNum);
            // строку добавляю в объект после чего ставлю пробел
            sb.append(strInt).append(" ");
        }
        // объект StringBuilder конвертирую в String и методом
        // trim убираю лишние проблемы вначале и конце файла
        String strFromSb = sb.toString().trim();
        // Открываю файл для записи
        File writeFile = new File(file02);
        // Создаю буффер для записи
        BufferedWriter bw = new BufferedWriter(new FileWriter(writeFile));
        // Записываю строку в буффер
        bw.write(strFromSb);
        // Закрываю буффер
        bw.close();
    }
}
