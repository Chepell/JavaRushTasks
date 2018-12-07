package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

/**
 * В классе Solution необходимо реализовать простейшую обработку аннотаций.
 * <p>
 * В методы printFullyQualifiedNames и printValues приходит класс. Если этот класс отмечен аннотацией PrepareMyTest,
 * необходимо вывести на экран fullyQualifiedNames и values в соответствующих методах и вернуть true.
 * Если же аннотация PrepareMyTest отсутствует - вернуть false.
 * <p>
 * Для вывода на экран классов из массива value используй сокращенное имя (getSimpleName).
 * <p>
 * <p>
 * Требования:
 * 1. Метод printFullyQualifiedNames должен возвращать false в случае,
 * если переданный в качестве параметра класс не отмечен аннотацией @PrepareMyTest.
 * 2. Метод printValues должен возвращать false в случае, если переданный в качестве параметра класс
 * не отмечен аннотацией @PrepareMyTest.
 * 3. Метод printFullyQualifiedNames должен выводить на экран все элементы массива fullyQualifiedValues,
 * и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.
 * 4. Метод printValues должен выводить на экран все элементы массива value используя их сокращенное имя,
 * и возвращать true, если полученный класс отмечен аннотацией @PrepareMyTest.
 */

public class Solution {
	public static void main(String[] args) {
		printFullyQualifiedNames(Solution.class);
		printFullyQualifiedNames(SomeTest.class);

		printValues(Solution.class);
		printValues(SomeTest.class);
	}

	public static boolean printFullyQualifiedNames(Class c) {
		if (c.isAnnotationPresent(PrepareMyTest.class)) return false;

		Annotation annotation = c.getAnnotation(PrepareMyTest.class);

		return true;
	}

	public static boolean printValues(Class c) {
		if (c.isAnnotationPresent(PrepareMyTest.class)) return false;

		Annotation annotation = c.getAnnotation(PrepareMyTest.class);

		return true;
	}
}
