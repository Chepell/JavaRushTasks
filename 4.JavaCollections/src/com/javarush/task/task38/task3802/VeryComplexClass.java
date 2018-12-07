package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)
*/

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Напиши реализацию метода veryComplexMethod().
 * Он должен всегда кидать какое-нибудь проверяемое исключение.
 * Кинуть исключение (throw) явно нельзя.
 *
 *
 * Требования:
 * 1. Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.
 * 2. Метод veryComplexMethod класса veryComplexClass должен бросать исключение.
 * 3. Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).
 * 4. Метод veryComplexMethod не должен быть приватным.
 *
 */

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
		Path path = Paths.get("file.txt");
		InputStream inputStream = Files.newInputStream(path);
	}

	public static void main(String[] args) throws Exception {
		new VeryComplexClass().veryComplexMethod();
	}
}
