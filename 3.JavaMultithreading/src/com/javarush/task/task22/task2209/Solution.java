package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В классе Solution не должно быть статических полей.
3. В методе getLine должен быть использован StringBuilder.
4. Метод getLine должен возвращать пустую строку(пустой StringBuilder) в случае если ему не были переданы параметры(слова).
5. Метод getLine не должен изменять переданные ему параметры(слова).
6. Все слова переданные в метод getLine должны быть включены в результирующую строку, если это возможно.
7. Вывод на экран должен соответствовать условию задачи.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // буффер для чтения имени файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // читаю и сохраняю в переменную имя файла
        String fileName = reader.readLine();
        // имя прочитанно, закрываю ридер
        reader.close();
//        String fileName = "reverse.txt"; // подавался тестовый набор : Киев Нью-Йорк Амстердам Вена Ашхабад Мельбурн Прага

        // ридер для чтения построчно из файла
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        // переменная для чтения строки из файла
        String line;
        // объект для сохранения всех прочитанных строк
        StringBuilder sb = new StringBuilder();
        // в цикле читаю файл построчно, пока есть что читать
        while (bufferedReader.ready()) {
            // сохраняю в переменную прочитанную строку, проверюя нет ли BOM символа, если есть удаляю
            line = bufferedReader.readLine().replace("\uFEFF", "");
            // добавляю строку в объект полсе чего добавляю пробел что бы вновь прочитанная строка не слиплась с существующей
            sb.append(line).append(" ");
        }
        // цикл чтения файла закончен, закрываю ридер
        bufferedReader.close();

        // конвертирую полученный объект класса StringBuilder в строку и методом
        // trim() отрезаю лишние пробелы по стронам
        String fullString = sb.toString().trim();
        // режу строку по пробелам и помещаю результат в массив строк
        String[] strArray = fullString.split(" ");

        // отправлю полученный массив строк в метод получения цепочки городов
        StringBuilder result = getLine(strArray);
        // вывожу на печать
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        // проверка, что аргументом передан не пустой массив
        if (words == null || words.length == 0) return new StringBuilder();
        // конвертирую массив в список
        List<String> list = new ArrayList<>(Arrays.asList(words));
        // создаю список для хранения всех получисшихся строк
        List<StringBuilder> listSb = new ArrayList<>();
        // циклом иду по списку городов
        for (int i = 0; i < list.size(); i++) {
            // добавляю в список строку с
            // городами начинающуюся с города в i-й позиции
            listSb.add(getSb(list, i));
        }
        // возвращаю самую длинную строку из списка
        return getMaxLenSbFromList(listSb);
    }


    /// ВСПОМОГАТЕЛЬНЫЕ МЕТОДЫ ///


    // метод в списке строковых объектов ищет объект максимальной длины
    private static StringBuilder getMaxLenSbFromList(List<StringBuilder> listSb) {
        // переменная для хранения индекса элемента с максимальной длиной
        int maxStringInd = 0;
        // переменная для хранения значения максимальной длины найденной строки
        int maxStringLen = 0;
        // циклом иду по списку
        for (int i = 0; i < listSb.size(); i++) {
            // на каждой итерации сохраняю в перменную текущую длину элемента
            int currStringLen = listSb.get(i).length();
            // сравниваю с максимальным значением
            if (currStringLen > maxStringLen) {
                // если текущая строка длинее, то обновляю значение максимальной длины
                maxStringLen = currStringLen;
                // и сохраняю индекс нового самого длинного элемента
                maxStringInd = i;
            }
        }
        // выхожу из цикла и возвращаю элемент по индексу
        return listSb.get(maxStringInd);
    }

    // метод находит максимально возможную строку из городов стартуя с позиции в списке переданной в качестве аргумента
    private static StringBuilder getSb(List<String> list, int startPosition) {
        // создаю копию списка, все манипуляции далее произожу с ним что бы не угробить основной список
        List<String> copyList = new ArrayList<>(list);
        // сохраняю начальный размер списка
        int baseListSize = copyList.size();
        // создаю строковый объект
        StringBuilder sb = new StringBuilder();
        // циклом иду по списку
        while (copyList.size() != 0 && baseListSize > 0) {
            // перым делом обновляю счетчик декрементирую размер списка
            // цикл в любом случае прервется
            baseListSize--;
            // если строковый объект пустой, то забираю из списка первый элемент
            if (sb.length() == 0) {
                String removeElement = copyList.remove(startPosition);
                sb.append(removeElement);
            } else {
                // иначе как минимум один город в строковом объекте есть
                // определяю последний символ в строковм объекте
                char lastChar0 = sb.charAt(sb.length() - 1);
                // добавляю пробел к строке
                sb.append(" ");
                // циклом иду по записям списка
                for (int i = 0; i < copyList.size(); i++) {
                    // в строку сохраняю элемент на текущем цикле
                    String sity1 = copyList.get(i);
                    // и сохраняю первую букву текущего элемента
                    char firstChar1 = sity1.charAt(0);
                    // проверяю буквы
                    if (Character.toUpperCase(lastChar0) == Character.toUpperCase(firstChar1)) {
                        // если буквы одинаковые, то удаляю текущий элемент из списка
                        copyList.remove(i);
                        // и добавляю его в объект
                        sb.append(sity1);
                        // и прерываю цикл for, надо искать слово заново по новому списку с учетом удаления
                        break;
                    }
                }
            }
        }
        return sb;
    }
}
