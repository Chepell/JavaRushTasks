package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 * Artem Voytenko
 * 02.12.2018
 * Я уже создал абстрактный класс ShapeDecorator, поэтому:
 * 1) Класс RedShapeDecorator сделай наследником класса ShapeDecorator.
 * 2) Реализуй приватный метод setBorderColor с одним параметром типа Shape.
 * Он должен выводить на экран фразу "Setting border color for XXX to red.",
 * где XXX - имя конкретного декорируемого класса (можешь воспользоваться методами
 * getClass().getSimpleName() вызванными на объекте полученном в качестве параметра).
 * 3) Переопредели метод draw, в нем сначала измени цвет отображаемого объекта с
 * помощью метода setBorderColor, а потом нарисуй его.
 *
 *
 * Требования:
 * 1. Класс RedShapeDecorator должен быть потомком класса ShapeDecorator.
 * 2. Метод setBorderColor должен выводить на экран фразу соответствующую условию задачи.
 * 3. Метод setBorderColor должен быть приватным.
 * 4. В методе draw класса RedShapeDecorator должен быть изменен цвет декорируемого объекта и вызван его метод draw.
 * 5. Публичный конструктор класса RedShapeDecorator должен принимать один параметр типа Shape.
 */

public class RedShapeDecorator extends ShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape) {
		super(decoratedShape);
	}

	private void setBorderColor(Shape shape) {
		System.out.printf("Setting border color for %s to red.%n", shape.getClass().getSimpleName());
	}

	@Override
	public void draw() {
		setBorderColor(decoratedShape);
		super.draw();
	}
}
