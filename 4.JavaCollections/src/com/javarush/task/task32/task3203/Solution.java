package com.javarush.task.task32.task3203;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/*
Пишем стек-трейс
*/
public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        Writer writer = new StringWriter(); // создаю свой строковый райтер
        PrintWriter printWriter = new PrintWriter(writer); // оборочиваю свой райтер
        throwable.printStackTrace(printWriter); // передаю методу, который в него пишет как в поток
        return writer.toString(); // а теперь конвертирую поток в строку
    }
}
