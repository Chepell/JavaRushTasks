package com.javarush.task.task10.task1017;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Безопасное извлечение из списка
Создать список целых чисел.
Ввести с клавиатуры 20 целых чисел.
Создать метод по безопасному извлечению чисел из списка:
int safeGetElement(ArrayList<Integer> list, int index, int defaultValue)
Метод должен возвращать элемент списка (list) по его индексу (index).
Если в процессе получения элемента возникло исключение, его нужно перехватить, и метод должен вернуть defaultValue.


Требования:
1. Программа должна считывать 20 чисел с клавиатуры.
2. Программа должна выводить данные на экран.
3. Метод safeGetElement должен возвращать элемент списка по индексу, если исключений внутри метода не возникло.
4. Метод safeGetElement должен возвращать defaultValue, если возникло исключений внутри метода. Исключение перехватить.
5. Метод safeGetElement не должен кидать исключения.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // объект для чтения с клавиатуры
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // объявление и инициализация списка для хранения целых числе
        ArrayList<Integer> list = new ArrayList<>();
        // добавление 20ти чисел с клавиатуры в список
        for (int i = 0; i < 20; i++) {
            // парсинг введенной строки в целое число
            int x = Integer.parseInt(reader.readLine());
            list.add(x);
        }

        // использование метода безопастного извелечения элемента
        System.out.println(safeGetElement(list, 5, 1));
        System.out.println(safeGetElement(list, 20, 7));
        System.out.println(safeGetElement(list, -5, 9));
    }

    // метод извления элементов из списка с работой с исключениями
    public static int safeGetElement(ArrayList<Integer> list, int index, int defaultValue) {
        // переменная для результата взятия значения по индексу
        int result;

        // блок исключения
        try {
            // пытюсь взять значение из списка и поместить в переменную
            result = list.get(index);
        } catch (Exception e) { // если возникло исключение
            // возвращаю значение по умолчанию
            return defaultValue;
        }
        // если все ок и исключения не было
        return result;
    }

}
