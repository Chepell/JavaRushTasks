package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Artem Voytenko
 * 26.11.2018
 * <p>
 * 6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber).
 * Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber.
 * Реализация метода должна:
 * 6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.
 * 6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.
 * 6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.
 * 6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для
 * заданной стратегии и заданного множества элементов. Время вывести в миллисекундах.
 * При замере времени работы метода можно пренебречь переключением процессора на другие потоки,
 * временем, которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты).
 * Замер времени произведи с использованием объектов типа Date.
 * 6.2.3.5. Замерять и выводить время необходимое для отработки
 * метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.
 * 6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества,
 * которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".
 * 6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.
 * 6.3. Проверь, что программа работает и тест пройден.
 * <p>
 * <p>
 * Требования:
 * 1. Метод getIds должен для переданного множества строк возвращать множество идентификаторов.
 * 2. Метод getStrings должен для переданного множества идентификаторов возвращать множество строк.
 * 3. Метод testStrategy должен выводить на экран имя класса стратегии.
 * 4. Метод testStrategy должен генерировать тестовое множество строк используя метод generateRandomString класса Helper (количество элементов должно быть равно параметру elementsNumber).
 * 5. Метод testStrategy должен создавать объект типа Shortener используя переданную стратегию.
 * 6. Метод testStrategy должен замерять количество времени выполнения методов getIds и getStrings используя объекты типа Date.
 * 7. Метод testStrategy должен сравнивать количество сгенерированных строк и строк в множестве полученном в результате работы метода getStrings и выводить на экран результат прохождения теста.
 * 8. В методе main должен быть вызван метод testStrategy.
 */

public class Solution {
	public static void main(String[] args) {
		testStrategy(new HashMapStorageStrategy(), 10000);

		testStrategy(new OurHashMapStorageStrategy(), 10000);

//		testStrategy(new FileStorageStrategy(), 100);

		testStrategy(new OurHashBiMapStorageStrategy(), 10000);

		testStrategy(new HashBiMapStorageStrategy(), 10000);

		testStrategy(new DualHashBidiMapStorageStrategy(), 10000);

	}

	public static Set<Long> getIds(Shortener shortener, Set<String> strings) {
		Set<Long> resultSet = new HashSet<>();
		for (String string : strings) {
			resultSet.add(shortener.getId(string));
		}
		return resultSet;
	}

	public static Set<String> getStrings(Shortener shortener, Set<Long> keys) {
		Set<String> resultSet = new HashSet<>();
		for (Long key : keys) {
			resultSet.add(shortener.getString(key));
		}
		return resultSet;
	}

	public static void testStrategy(StorageStrategy strategy, long elementsNumber) {
		Shortener shortener = new Shortener(strategy);
		Set<String> generatedSet = new HashSet<>();
		Helper.printMessage(strategy.getClass().getName());
		for (int i = 0; i < elementsNumber; i++) {
			generatedSet.add(Helper.generateRandomString());
		}
		Date startDate = new Date();
		Set<Long> ids = getIds(shortener, generatedSet);
		Date endDate = new Date();
		long delay = endDate.getTime() - startDate.getTime();
		Helper.printMessage("getIds worked in " + delay + " ms");
		Date startDate1 = new Date();
		Set<String> resultSet = getStrings(shortener, ids);
		Date endDate1 = new Date();
		long delay1 = endDate1.getTime() - startDate1.getTime();
		Helper.printMessage("getStrings worked in " + delay1 + " ms");

		if (resultSet.equals(generatedSet)) {
			Helper.printMessage("Тест пройден.");
		} else {
			Helper.printMessage("Тест не пройден.");
		}
	}
}
