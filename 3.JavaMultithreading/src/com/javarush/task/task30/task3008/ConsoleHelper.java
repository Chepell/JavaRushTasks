package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// вспомогательный класс для чтения/записи в консоль
public class ConsoleHelper {
    // статическое поле читалки из консоли
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    //region вывод сообщения на консоль
    public static void writeMessage(String message) {
        System.out.println(message);
    }
    //endregion

    //region чтение строки из консоли
    public static String readString() {
        // вечный цикл, который повторяется пока не будет считана строка
        // если строка будет успешно считана, то тут же произойтет ее возврат и цикл завершится
        while (true) {
            try {
                return reader.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }
    //endregion

    //region чтение целого числа из консоли
    public static int readInt() {
        // опять вечный цикл
        while (true) {
            try {
                // использую уже готовый метод чтения строки
                // и пробую отпарсить в число, если получилось то сразу возврат
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
    //endregion
}