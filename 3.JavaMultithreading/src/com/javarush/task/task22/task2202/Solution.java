package com.javarush.task.task22.task2202;

import java.util.ArrayList;
import java.util.List;

/*
Найти подстроку
Метод getPartOfString должен возвращать подстроку
начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.

Пример:
"JavaRush - лучший сервис обучения Java."

Результат:
"- лучший сервис обучения"

Пример:
"Амиго и Диего лучшие друзья!"

Результат:
"и Диего лучшие друзья!"

На некорректные данные бросить исключение TooShortStringException (сделать исключением).


Требования:
1. Класс TooShortStringException должен быть потомком класса RuntimeException.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если в метод getPartOfString были переданы некорректные данные,
    должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку начиная с символа
    после 1-го пробела и до конца слова, которое следует после 4-го пробела.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        // если передана пустая строка, то сразу выбрасываю исключение
        if (string == null) throw new TooShortStringException();
        // список для хранения индексов пробелов
        List<Integer> indOfSpase = new ArrayList<>();
        // циклом иду по строке
        for (int i = 0; i < string.length(); i++) {
            // и если обнаружил пробел, то добавляю его индекс в список
            if (string.charAt(i) == ' ') indOfSpase.add(i);
        }
        // если список меньше 4х элементов, то в строке не было 4х пробелов и выбрасываю исключение
        if (indOfSpase.size() < 4) throw new TooShortStringException();

        // переменная для индекса подрезки после
        // первого проблеа, поэтому добавляю 1
        int firstWhitespace = indOfSpase.get(0) + 1;
        // переменная для итоговой подрезанной строки
        String cutString;

        // если пробелов 4, то до с конца нечего подрезать
        if (indOfSpase.size() == 4) {
            cutString = string.substring(firstWhitespace);
        } else {
            // иначе беру из списка индекс 5го пробела в строке и подрезаю до него
            int lastWhitespace = indOfSpase.get(4);
            cutString = string.substring(firstWhitespace, lastWhitespace);
        }
        // возвращаю итоговую строку
        return cutString;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
