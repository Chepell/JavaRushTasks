package com.javarush.task.task36.task3601;

/**
 * @autor Artem Voytenko
 */

// представление взаимодействует с контроллером
public class View {
	private Controller controller;

	public View() {
		this.controller = new Controller();
	}

	// берет данные у контроллера и представляет их нужным образом
	public void fireEventShowData() {
		System.out.println(controller.onDataListShow());
	}
}
