package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

//    public static ByteArrayOutputStream getPassword() {
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        Random random = new Random();
//        boolean passwordIsGood = false;
//        // цикл продолжается пока не будет сгенерирован надежный пароль
//        while (!passwordIsGood) {
//            byteArrayOutputStream = new ByteArrayOutputStream();
//            // цикл генерации каждого символа пароля и запись в байтовый поток
//            for (int i = 0; i < 8; i++) {
//                int ch = (random.nextInt(75) + 48); // ограничение по значениям из таблицы ASCII
//                while ((ch >= 58 && ch <= 64) || (ch >= 91 && ch <= 96)) {
//                    ch = (random.nextInt(75) + 48);
//                }
//                byteArrayOutputStream.write(ch); // запись посимвольно в поток
//            }
//            // конвертация сгенерированного потока в строку для проверки
//            String currentPassword = byteArrayOutputStream.toString();
//            // проверка, что в пароле есть хотя бы одна цифра
//            boolean isDigits = currentPassword.matches(".*\\p{Digit}+.*");
//            // что есть хотя бы один символ в нижнем регистре
//            boolean isLowerLetters = currentPassword.matches(".*\\p{Lower}+.*");
//            // что есть хотя бы один символ в вержнем регистре
//            boolean isUpperLetters = currentPassword.matches(".*\\p{Upper}+.*");
//            // и общая проверка, соответствует ли пароль всем условиям одновременно
//            passwordIsGood = isDigits && isLowerLetters && isUpperLetters;
//            // если соответсвует то цикл больше не повторяется
//        }
//        return byteArrayOutputStream;
//    }

    public static ByteArrayOutputStream getPassword() {
        final String symbolSet = "abcdefghigklmnopqrstvwxyzABCDEFGHIGKLMNOPQRSTVWXYZ0123456789";
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Random random = new Random();
        boolean passwordIsGood = false;
        // цикл продолжается пока не будет сгенерирован надежный пароль
        while (!passwordIsGood) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            // цикл генерации каждого символа пароля и запись в байтовый поток
            for (int i = 0; i < 8; i++) {
                int ch = symbolSet.charAt(random.nextInt(symbolSet.length()));
                byteArrayOutputStream.write(ch); // запись посимвольно в поток
            }
//            // конвертация сгенерированного потока в строку для проверки
//            String currentPassword = byteArrayOutputStream.toString();
//            // проверка, что в пароле есть хотя бы одна цифра
//            boolean isDigits = currentPassword.matches(".*\\p{Digit}+.*");
//            // что есть хотя бы один символ в нижнем регистре
//            boolean isLowerLetters = currentPassword.matches(".*\\p{Lower}+.*");
//            // что есть хотя бы один символ в вержнем регистре
//            boolean isUpperLetters = currentPassword.matches(".*\\p{Upper}+.*");
//            // и общая проверка, соответствует ли пароль всем условиям одновременно
//            passwordIsGood = isDigits && isLowerLetters && isUpperLetters;
//            // если соответсвует то цикл больше не повторяется

            // все в одну строку
            passwordIsGood = byteArrayOutputStream.toString()
                    .matches("(?=.*[0-9])" + // строка содержит хотя бы одну цифру
                            "(?=.*[a-z])" + // хотя бы одну малеьнкую букву
                            "(?=.*[A-Z])" + // хотя бы одну большую
                            "[0-9a-zA-Z]{8}"); // длина 8 символов и такие вот варианты
        }
        return byteArrayOutputStream;
    }
}