package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Artem Voytenko
 * 27.11.2018
 */

public class Entry implements Serializable {
	Long key;
	String value;
	Entry next;
	int hash;

	public Entry(int hash, Long key, String value, Entry next) {
		this.key = key;
		this.value = value;
		this.next = next;
		this.hash = hash;
	}

	public Long getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() { return key + "=" + value; }

	@Override
	public int hashCode() {
		return Objects.hashCode(key) ^ Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Entry entry = (Entry) o;
		return Objects.equals(key, entry.getKey()) &&
				Objects.equals(value, entry.getValue());
	}
}