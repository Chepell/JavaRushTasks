package com.javarush.task.task28.task2810.model;

/**
 * Artem Voytenko
 * 08.12.2018
 */

// класс будет обобщать способ получения данных о вакансиях
public class Provider {
	private Strategy strategy;

	public Provider(Strategy strategy) {
		this.strategy = strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
}
