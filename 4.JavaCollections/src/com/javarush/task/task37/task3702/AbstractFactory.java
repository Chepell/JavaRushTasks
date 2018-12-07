package com.javarush.task.task37.task3702;

/**
 * @autor Artem Voytenko
 */

// Интерфейс для обобщения обоих фабрик
public interface AbstractFactory {
	// сигнатура метода для реализации в фабриках
	Human getPerson(int age);
}
