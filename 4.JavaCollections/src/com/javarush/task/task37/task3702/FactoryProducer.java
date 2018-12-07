package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

/**
 * @autor Artem Voytenko
 */

// класс со статичными методами для создания нужной фабрики
public class FactoryProducer {
	// публичный статичный инам класса, инам по умолчанию статичный
	public enum HumanFactoryType {
		MALE,
		FEMALE
	}

	// метод создающий и возвращающий нужную фабрику исходя из переданного параметра в виде emun
	public static AbstractFactory getFactory(HumanFactoryType sex) {
		AbstractFactory factory = null;
		if (sex == HumanFactoryType.MALE) factory = new MaleFactory();
		if (sex == HumanFactoryType.FEMALE) factory = new FemaleFactory();
		return factory;
	}
}
