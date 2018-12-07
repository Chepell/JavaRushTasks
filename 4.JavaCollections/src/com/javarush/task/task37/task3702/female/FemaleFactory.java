package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

/**
 * @autor Artem Voytenko
 */

// фабрика реализующая интерфейс
public class FemaleFactory implements AbstractFactory {
	// метод создающий и возвращающий нужный объект в зависимости от параметра возраста
	public Human getPerson(int age) {
		Human person;
		if (age <= KidGirl.MAX_AGE) {
			person = new KidGirl();
		} else if (age <= TeenGirl.MAX_AGE) {
			person = new TeenGirl();
		} else {
			person = new Woman();
		}
		return person;
	}
}
