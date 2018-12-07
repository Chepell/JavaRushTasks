package com.javarush.task.task33.task3310.tests;

import com.javarush.task.task33.task3310.Helper;
import com.javarush.task.task33.task3310.Shortener;
import com.javarush.task.task33.task3310.strategy.HashBiMapStorageStrategy;
import com.javarush.task.task33.task3310.strategy.HashMapStorageStrategy;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Artem Voytenko
 * 28.11.2018
 * <p>
 * Требования:
 * 1. Метод getTimeForGettingStrings должен возвращать время в миллисекундах необходимое для получения
 * всех строк для множества идентификаторов ids.
 * 2. Метод getTimeForGettingIds должен возвращать время в миллисекундах необходимое для получения
 * всех идентификаторов для множества строк strings.
 * 3. В методе testHashMapStorage должно быть выполнено сравнение времени получения множества ключей
 * и множества значений для стратегий HashMapStorageStrategy и HashBiMapStorageStrategy.
 */

// тест который проверит, что получить идентификатор для строки используя стратегию
// HashBiMapStorageStrategy можно быстрее, чем используя стратегию HashMapStorageStrategy
public class SpeedTest {
	public long getTimeForGettingIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
		Date before = new Date();
//		long before = System.currentTimeMillis();
//		for (String string : strings) {
//			ids.add(shortener.getId(string));
//		}
		strings.forEach(str -> ids.add(shortener.getId(str)));
//		return System.currentTimeMillis() - before;
		return new Date().getTime() - before.getTime();
	}

	public long getTimeForGettingStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
		Date before = new Date();
//		long before = System.currentTimeMillis();
//		for (Long id : ids) {
//			strings.add(shortener.getString(id));
//		}
		ids.forEach(id -> strings.add(shortener.getString(id)));
//		return System.currentTimeMillis() - before;
		return new Date().getTime() - before.getTime();
	}

	@Test
	public void testHashMapStorage() {
		Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
		Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

		Set<String> origStrings = new HashSet<>();
		for (int i = 0; i < 10000; i++) {
			origStrings.add(Helper.generateRandomString());
		}

		Set<Long> ids = new HashSet<>();
		long timeForGettingIds1 = getTimeForGettingIds(shortener1, origStrings, ids);
		long timeForGettingStrings1 = getTimeForGettingStrings(shortener1, ids, new HashSet<>());

		ids.clear();
		long timeForGettingIds2 = getTimeForGettingIds(shortener2, origStrings, ids);
		long timeForGettingStrings2 = getTimeForGettingStrings(shortener2, ids, new HashSet<>());

//		Assert.assertEquals(timeForGettingIds1, timeForGettingIds2, 30);
		Assert.assertEquals(timeForGettingStrings1, timeForGettingStrings2, 30);
	}
}
