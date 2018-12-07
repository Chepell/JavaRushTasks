package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/* 
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров
(Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert с параметром double в случае,
    если значение параметра obj может быть корректно преобразовано в число типа double.
5. Программа должна вызывать метод alert с параметром String в случае,
    если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) {
        // Создаю ссылки на массивы пар значений request:value
        String[] requestArray;
        String[] valueArray;

        String str = "";

        // объект ввода строки
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            str = reader.readLine();
            // ридер больше не понадобится
            reader.close();
        } catch (IOException e) {
            System.out.println();
//            e.printStackTrace();
        }

        // если строка пустая, то завершаю программу
        if (str.isEmpty()) {
            System.out.println("String is empty!");
            return;
        }
        ////// ОБЫЧНАЯ ОБРЕЗКА //////
//        // определяю на каком индексе ?
//        // и добавляю +1 что бы отрезать и его от строки
//        int indexQuestMark = str.indexOf('?') + 1;
//        // получаю строку только после ?
//        String cutStr = str.substring(indexQuestMark);
//
//        // режу строку по знаку & и помещаю все в массив строк
//        // созданную ранее переменную-ссылку указываю на массив
//        requestArray = cutStr.split("&");

        ////// СПЕЦ МЕТОД //////
        // перобразую строку в объект URI
        URI uri = URI.create(str);
        // метод парсит из строки запросы
        // затем split режет запросы по символу & и помещает в массив
        requestArray = uri.getQuery().split("&");

        // делаю копию массива и указываю на вторую ссылку
        valueArray = requestArray.clone();
        // создаю строку под значение obj
        String objVal = "";

        // цикл по всем элементам массива
        for (int i = 0; i < requestArray.length; i++) {
            // если в элементе есть =, значит нужно дробить строку на request:value
            if (requestArray[i].contains("=")) {
                // сохраняю значение во временную переменную
                String tmpStr = requestArray[i];
                // нахожу индекс =
                int index = tmpStr.indexOf("=");
                // в массиве меняю текущее значение на отрезанное до =
                requestArray[i] = tmpStr.substring(0, index);
                // в массиве меняю текущее значение на отрезанное после =
                valueArray[i] = tmpStr.substring(index + 1);
            } else { // иначе если в элементе нет =
                // то там только request и первый массив не трогаю
                // значения value нет, поэтому меняю этот элемент в массиве на ""
                valueArray[i] = "";
            }
            // после того как все значения исправил в этом же цикле
            // ищу в requestArray значение obj
            if ("obj".equals(requestArray[i])) {
                // сохраняю значение в строковую переменную
                objVal = valueArray[i];
            }
        }

        // печать значений в одну строку через пробел
        for (String i : requestArray) {
            System.out.printf("%s ", i);
        }

        // если значение не пустое, то продолжаю
        if (!objVal.isEmpty()) {
            // переход на новую строку
            System.out.println();
            // использую try-catch для парсинга в число
            try {
                // пробую отпарсить в число и отдаю методу в качестве аргумента
                alert(Double.parseDouble(objVal));
            } catch (NumberFormatException e) {
                // если отпарсить не вышло, то просто отдаю строку аргументом
                alert(objVal);
            }
        }
    }

    // тут методы с перегрузкой
    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
