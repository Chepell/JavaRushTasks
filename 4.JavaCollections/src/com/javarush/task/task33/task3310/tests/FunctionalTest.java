package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * Artem Voytenko
 * 28.11.2018
 * Мы много раз тестировали наши стратегии с помощью метода testStrategy() класса Solution.
 * Пришло время написать настоящие юнит тесты с использованием junit.
 * 14.1. Прочитай что такое юнит тесты.
 * 14.2. Скачай и подключи библиотеку Junit 4.12. Разберись как ей пользоваться.
 * Библиотека Junit зависит от библиотеки hamcrest-core. Подключи и ее. Используй версию 1.3.
 * 14.3. Добавь класс FunctionalTest в пакет tests. В этом классе мы проверим функциональность наших стратегий.
 * 14.4. Добавь в класс FunctionalTest метод testStorage(Shortener shortener). Он должен:
 * 14.4.1. Создавать три строки. Текст 1 и 3 строк должен быть одинаковым.
 * 14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shortener.
 * 14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
 * <p>
 * Подсказка: метод Assert.assertNotEquals.
 * <p>
 * 14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны.
 * <p>
 * Подсказка: метод Assert.assertEquals.
 * <p>
 * 14.4.5. Получать три строки по трем идентификаторам с помощью shortener.
 * 14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
 * <p>
 * Подсказка: метод Assert.assertEquals.
 * <p>
 * 14.5. Добавь в класс FunctionalTest тесты:
 * 14.5.1. testHashMapStorageStrategy()
 * 14.5.2. testOurHashMapStorageStrategy()
 * 14.5.3. testFileStorageStrategy()
 * 14.5.4. testHashBiMapStorageStrategy()
 * 14.5.5. testDualHashBidiMapStorageStrategy()
 * 14.5.6. testOurHashBiMapStorageStrategy()
 * Каждый тест должен иметь аннотацию @Test, создавать подходящую стратегию, создавать
 * объект класса Shortener на базе этой стратегии и вызывать метод testStorage для него.
 * Запусти и проверь, что все тесты проходят.
 * <p>
 * <p>
 * Требования:
 * 1. Класс FunctionalTest должен быть добавлен в созданный пакет tests.
 * 2. В методе testStorage должны быть трижды вызваны методы getId и getString.
 * 3. Тестовые методы перечисленные в условии задачи должны быть отмечены только аннотацией @Test.
 * 4. В каждом тестовом методе должен содержаться вызов метода testStorage.
 */

public class FunctionalTest {
	public void testStorage(Shortener shortener) {
		String str01 = "vbfgr565";
		String str02 = "weQWQcd56lkmJK";
		String str03 = "vbfgr565";

		Long id01 = shortener.getId(str01);
		Long id02 = shortener.getId(str02);
		Long id03 = shortener.getId(str03);

		Assert.assertNotEquals(id02, id01);
		Assert.assertNotEquals(id02, id03);
		Assert.assertEquals(id01, id03);

		String resultStr01 = shortener.getString(id01);
		String resultStr02 = shortener.getString(id02);
		String resultStr03 = shortener.getString(id03);

		Assert.assertEquals(resultStr01, str01);
		Assert.assertEquals(resultStr02, str02);
		Assert.assertEquals(resultStr03, str03);
	}

	@Test
	public void testHashMapStorageStrategy() {
		Shortener shortener = new Shortener(new HashMapStorageStrategy());
		testStorage(shortener);
	}

	@Test
	public void testOurHashMapStorageStrategy() {
		Shortener shortener = new Shortener(new OurHashMapStorageStrategy());
		testStorage(shortener);
	}

	@Test
	public void testFileStorageStrategy() {
		Shortener shortener = new Shortener(new FileStorageStrategy());
		testStorage(shortener);
	}

	@Test
	public void testHashBiMapStorageStrategy() {
		Shortener shortener = new Shortener(new HashBiMapStorageStrategy());
		testStorage(shortener);
	}

	@Test
	public void testDualHashBidiMapStorageStrategy() {
		Shortener shortener = new Shortener(new DualHashBidiMapStorageStrategy());
		testStorage(shortener);
	}

	@Test
	public void testOurHashBiMapStorageStrategy() {
		Shortener shortener = new Shortener(new OurHashBiMapStorageStrategy());
		testStorage(shortener);
	}
}
