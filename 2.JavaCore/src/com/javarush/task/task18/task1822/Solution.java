package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id,
и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        // сохраняю аргумент в строку
        String id = args[0];

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        File file = new File(fileName);
        BufferedReader readFile = new BufferedReader(new FileReader(file));

        String str;
        String stringID;
        // строка инициируется в теле цикла
        // цикл выполняется пока строка есть
        while ((str = readFile.readLine()) != null) {
            // определяю положение первого пробела в строке
            int spaceInd = str.indexOf(" ");
            // подрезаю строку по пробелу, оставляю только id
            stringID = str.substring(0, spaceInd);
            // сравниваю отрезанный id с тем, что был подан
            // в качестве параметра при запуске программы
            if (id.equals(stringID)) {
                // если найден, то вывожу на экран
                System.out.println(str);
                // и дострочно прекращаю цикл, обрабатывать
                // весь файл не имеет смысла, поле уже найдено
                break;
            }
        }
        readFile.close();
    }
}
