package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/*
Найти класс по описанию
*/
public class Solution {
	public static void main(String[] args) {
		System.out.println(getExpectedClass());
	}


	public static Class getExpectedClass() {
		// получаю массив классов внутри Collections
		Class<?>[] declaredClasses = Collections.class.getDeclaredClasses();
		// циклом иду по всем классам
		for (Class<?> c : declaredClasses) {
			// получаю маску модификаторов доступа для класса
			int mod = c.getModifiers();
			// проверка что у класса есть модификаторы private и static
			if (Modifier.isPrivate(mod) && Modifier.isStatic(mod)) {
				// провека что класс c является потомком List
				if (List.class.isAssignableFrom(c)) {
					try {
						// вызываю конструктор класса по умолчанию
						Constructor<?> constructor = c.getDeclaredConstructor();
						// делаю конструктор доступным
						constructor.setAccessible(true);
						// создаю объект класса
						List list = (List) constructor.newInstance();
						// пытаюсь вернуть нулевой элемент
						list.get(0); // но данный метод запрещен и вызывает экспшен
					} catch (IndexOutOfBoundsException e) {
						// ловлю данный экспепшн и возвращаю класс на котором он произошел
						return c;
					} catch (NoSuchMethodException | InstantiationException |
							IllegalAccessException | InvocationTargetException e) {
					}
				}
			}
		}
		return null;
	}
}

//Описание класса:
//1. Реализует интерфейс List;
//2. Является приватным статическим классом внутри популярного утилитного класса;
//3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
//Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.