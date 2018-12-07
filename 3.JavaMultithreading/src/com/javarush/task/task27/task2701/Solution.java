package com.javarush.task.task27.task2701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Избавляемся от меток
Избавьтесь от меток в методе isSubstringPresent сохранив логику.
Метод возвращает true, в случае если строка substring является подстрокой строки string, иначе false.
В коде должны отсутствовать операторы break и continue.


Требования:
1. Метод isSubstringPresent должен возвращать true, если строка substring является подстрокой строки string.
2. Метод isSubstringPresent должен возвращать false, если строка substring НЕ является подстрокой строки string.
3. В методе isSubstringPresent должны отсутствовать операторы break.
4. В методе isSubstringPresent должны отсутствовать операторы continue.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String string = reader.readLine();
        String string = "vвы53";
//        String substring = reader.readLine();
        String substring = "ы5";

        if (isSubstringPresent(substring, string)) {
            System.out.println("String: \n" + substring + "\nis present in the string: \n" + string);
        } else {
            System.out.println("String: \n" + substring + "\nis not present in the string: \n" + string);
        }
    }

    static boolean isSubstringPresent(String substring, String string) {
        // останется в строке символов если вычесть сабстроку
        int len = string.length() - substring.length();
        // длина внешнего цикла на один больше чем количество оставшихся символов
        for (int i = 0; i <= len; i++) {
            // внутренниц цикл начинается с элемента внешнего
            for (int j = i; string.charAt(j) == substring.charAt(j - i); j++) {
                if (j == i + substring.length() - 1) return true;
            }
        }
        return false;
//        // переменная для хранения результата, если нашли совпадение
//        boolean found = false;
//        // сколько останется символов в строке если отнять сабстроку
//        int max = string.length() - substring.length();
//        label:
//        // цикл длиной в оставшиеся символы в строке + 1
//        for (int i = 0; i <= max; i++) {
//            // переменная для длины сабстроки
//            int length = substring.length();
//            // счетчик для строки, который связан с основным счетчиком цикла
//            int j = i;
//            // счетчик для сабстроки, каждую итерацию начинается с нуля
//            int k = 0;
//            // цикл по длине строки
//            while (length-- != 0) {
//                // если символы не равны в текущих положениях, то прерываю текущую итерацию, возвращаюсь в начало for
//                if (string.charAt(j++) != substring.charAt(k++)) {
//                    continue label;
//                }
//            }
//            // если вышли сюда из цикла, то зачит прошли по всей длине сабстроки и символы были равны в каждом положении
//            found = true;
//            break label;
//        }
//        return found;

//        boolean found = false;
//        if (string.contains(substring)) found = true;
//        return found;
    }
}

