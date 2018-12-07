package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * @autor Artem Voytenko
 */

// Модель вхаимодействует с БД, получая из нее данные
public class Model {
	private Service service;

	public Model() {
		this.service = new Service();
	}

	// метод обращается к БД и вызывает его метод получения данных
	public List<String> getStringDataList() {
		return service.getData();
	}
}
