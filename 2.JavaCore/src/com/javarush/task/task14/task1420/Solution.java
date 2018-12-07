package com.javarush.task.task14.task1420;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        int num1 = 0;
//        int num2 = 0;

        int num1 = 9;
        int num2 = 15;


//        try {
//            num1 = Math.abs(Integer.parseInt(reader.readLine()));
//            num2 = Integer.parseInt(reader.readLine());
//        } catch (NumberFormatException e) {
//            System.out.println("You didn't input integer number!");
//        }
//
//        // проброс исключений для не положительных целых чисел
//        if (num1 <= 0 || num2 <= 0) throw new Exception();

        // вызов метода
        int gcd = GCDrecursion(num1, num2);

        System.out.println(gcd);

    }


    // метода для расчета НОД
    public static int GCD(int num1, int num2) {
        // переменая для расчета НОД, по умолчанию любые числа делятся на 1.
        int greatestCommonDivisor = 1;

        // определяю наименьшее из числе переданных в качестве параметров
        int minOfTwoNumm = num2 < num1 ? num2 : num1;

        // меньшее число используется как максимальный итератор делителей по обоим числам
        // итерировать начинаю с 2, т.к. 1 это значение НОД по умолчанию
        for (int i = 2; i <= minOfTwoNumm; i++) {
            // если оба числа без остатка делятся на текущий итератор
            // то обновляю значение НОД
            if (num1 % i == 0 && num2 % i == 0) {
                greatestCommonDivisor = i;
            }
        }
        // возвращаю значение НОД
        return greatestCommonDivisor;
    }

    // метода для расчета НОД через рекурсию
    public static int GCDrecursion(int num1, int num2) {

        if (num2 == 0) {
            return num1;
        } else {
            return GCDrecursion(num2, num1 % num2);
        }

        //return num2 == 0 ? num1 : GCDrecursion(num2, num1 % num2);
    }
}
