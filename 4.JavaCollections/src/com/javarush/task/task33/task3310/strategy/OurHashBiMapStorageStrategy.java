package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Artem Voytenko
 * 28.11.2018
 * 11.2. Добавь в него два поля HashMap<Long, String> k2v и HashMap<String, Long> v2k.
 * Первое будет хранить соответствие ключа и значения, а второе наоборот: значения и ключа.
 * 11.3. Реализуй методы интерфейса StorageStrategy, обеспечив максимальную скорость.
 *
 * Подсказка: при добавлении новой пары ключ-значение необходимо добавлять ее сразу в два поля.
 *
 * Проверь новую стратегию в методе main(). Запусти программу и сравни скорость работы всех 4х стратегий. Убедись, что мы значительно увеличили скорость получения идентификатора. Но как ты понимаешь, у этого решения есть не только плюсы, но и минусы.
 * Подумай в каких случаях имеет смысл использовать OurHashBiMapStorageStrategy, а в каких HashMapStorageStrategy.
 *
 *
 * Требования:
 * 6. Метод getValue должен возвращать значение полученное из k2v.
 * 7. Метод getKey должен возвращать значение полученное из v2k.
 */

public class OurHashBiMapStorageStrategy implements StorageStrategy{
	HashMap<Long, String> k2v = new HashMap<>();
	HashMap<String, Long> v2k = new HashMap<>();


	@Override
	public boolean containsKey(Long key) {
		return k2v.containsKey(key);
	}

	@Override
	public boolean containsValue(String value) {
		return v2k.containsKey(value);
	}

	@Override
	public void put(Long key, String value) {
		k2v.put(key, value);
		v2k.put(value, key);
	}

	// Метод getKey должен возвращать значение полученное из v2k.
	@Override
	public Long getKey(String value) {
//		for (Map.Entry<String, Long> entry : v2k.entrySet()) {
//			if (entry.getKey().equals(value)) {
//				return entry.getValue();
//			}
//		}
//		return null;

		return v2k.get(value);
	}

	// Метод getValue должен возвращать значение полученное из k2v.
	@Override
	public String getValue(Long key) {
//		for (Map.Entry<Long, String> entry : k2v.entrySet()) {
//			if (entry.getKey().equals(key)) {
//				return entry.getValue();
//			}
//		}
//		return null;

		return k2v.get(key);
	}

}
