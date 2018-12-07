package com.javarush.task.task33.task3310.strategy;

import com.google.common.collect.HashBiMap;

import java.util.Map;

/**
 * Artem Voytenko
 * 28.11.2018
 */

public class HashBiMapStorageStrategy implements StorageStrategy {
	HashBiMap<Long, String> data = HashBiMap.create();


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
//		for (Map.Entry<Long, String> entry : data.entrySet()) {
//			if (entry.getValue().equals(value)) {
//				return entry.getKey();
//			}
//		}
//		return null;
		return data.inverse().get(value);
	}

	@Override
	public String getValue(Long key) {
		return data.get(key);
	}
}
