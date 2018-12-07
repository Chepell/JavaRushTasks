package com.javarush.task.task35.task3512;

// класс параметризованный типом Т
public class Generator<T> {
	Class<T> clazz;

	public Generator(Class<T> clazz) {
		this.clazz = clazz;
	}

	T newInstance() {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}
}