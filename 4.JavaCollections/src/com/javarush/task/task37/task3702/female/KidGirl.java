package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

/**
 * @autor Artem Voytenko
 */

public class KidGirl implements Human {
	// статичные константы для класса что бы отличать их по возрасту
	public static final int MAX_AGE = 12;

	@Override
	public String toString() {
		return "KidGirl{}";
	}
}
