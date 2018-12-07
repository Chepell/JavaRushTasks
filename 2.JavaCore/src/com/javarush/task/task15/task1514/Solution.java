package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
В статическом блоке инициализировать labels 5 различными парами ключ-значение.


Требования:
1. В классе Solution должен быть только один метод (main).
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнен 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();
    // без использования static-блока мэп парами
    // не наполняется, возникает ошибка
    // без блока наполняется только внутри метода main т.к. он static!
    // Ведь не нужно создавать объект! именно этим всегда и пользовался
    static {
        labels.put(53.56, "пятьдесят три");
        labels.put(0.5, "ноль");
        labels.put(-10.0, "минус десять");
        labels.put(21.11, "двадцать один");
        labels.put(80.14, "восемьдесят");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
