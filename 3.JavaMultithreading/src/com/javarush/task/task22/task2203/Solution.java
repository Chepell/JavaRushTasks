package com.javarush.task.task22.task2203;

import java.util.ArrayList;
import java.util.List;

/*
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее
    2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        // если переданна пустая строка то сразу выбрасываю исключение
        if (string == null) throw new TooShortStringException();
        // список для индексов Tab
        List<Integer> indOfTab = new ArrayList<>();
        // циклом прохожу по символам строки
        for (int i = 0; i < string.length(); i++) {
            // если в текущем индексе соответсвует tab, то добавляю индекс в лист
            if (string.charAt(i) == '\t') indOfTab.add(i);
        }
        // если в списке меньше 2х tab, то выбрасываю исключение
        if (indOfTab.size() < 2) throw new TooShortStringException();

        // сохраняю значения индексов для подрезки
        int indFirstTab = indOfTab.get(0) + 1;
        int indSecondTab = indOfTab.get(1);

        // подрезаю строку и возвращаю результат
        return string.substring(indFirstTab, indSecondTab);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
