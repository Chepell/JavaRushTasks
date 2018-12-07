package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * @autor Artem Voytenko
 */

// контроллер взаимодействует с моделью
public class Controller {
	private Model model;

	public Controller() {
		this.model = new Model();
	}

	// забирает данные из модели
	public List<String> onDataListShow() {
		return model.getStringDataList();
	}
}
