package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Artem Voytenko
 * 26.11.2018
 * <p>
 * 4.1. Создай класс Helper.
 * 4.1.1. Добавь в него статический метод String generateRandomString(),
 * который будет генерировать случайную строку. Воспользуйся для этого классами
 * SecureRandom и BigInteger. Подсказка: гугли запрос "random string java".
 * Строка может состоять из цифр и любой из 26 маленьких букв английского алфавита.
 * 4.1.2. Добавь в класс статический метод printMessage(String message).
 * Он должен выводить переданный текст в консоль. Весь дальнейший вывод в
 * программе должен быть реализован через этот метод!
 * 4.2. Создай класс ExceptionHandler.
 * 4.2.1. Добавь в него статический метод log(Exception e),
 * который будет выводить краткое описание исключения.
 * <p>
 * <p>
 * Требования:
 * 1. Метод generateRandomString класса Helper должен генерировать случайную
 * строку используя способ описанный в условии задачи.
 * 2. Метод printMessage класса Helper должен выводить переданный текст на экран.
 * 3. Метод log класса ExceptionHandler должен выводить на экран краткое описание исключения.
 */

public class Helper {
	public static String generateRandomString() {
		return new BigInteger(130, new SecureRandom()).toString(36);
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
