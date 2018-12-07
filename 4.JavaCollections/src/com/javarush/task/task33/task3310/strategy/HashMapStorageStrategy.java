package com.javarush.task.task33.task3310.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Artem Voytenko
 * 26.11.2018
 * <p>
 * Требования:
 * 1. Класс HashMapStorageStrategy должен поддерживать интерфейс StorageStrategy.
 * 2. В классе HashMapStorageStrategy должно быть создано и инициализировано поле data типа HashMap.
 * 3. В классе HashMapStorageStrategy должен быть корректно реализован метод containsKey.
 * 4. В классе HashMapStorageStrategy должен быть корректно реализован метод containsValue.
 * 5. В классе HashMapStorageStrategy должен быть корректно реализован метод put.
 * 6. В классе HashMapStorageStrategy должен быть корректно реализован метод getValue.
 * 7. В классе HashMapStorageStrategy должен быть корректно реализован метод getKey.
 */

public class HashMapStorageStrategy implements StorageStrategy {
	private HashMap<Long, String> data = new HashMap<>();

	@Override
	public boolean containsKey(Long key) {
		return data.containsKey(key);
	}

	@Override
	public boolean containsValue(String value) {
		return data.containsValue(value);
	}

	@Override
	public void put(Long key, String value) {
		data.put(key, value);
	}

	@Override
	public Long getKey(String value) {
		for (Map.Entry<Long, String> entry : data.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

	@Override
	public String getValue(Long key) {
		return data.get(key);
	}
}
