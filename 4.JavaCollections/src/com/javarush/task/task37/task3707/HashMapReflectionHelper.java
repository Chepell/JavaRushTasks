package com.javarush.task.task37.task3707;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


public class HashMapReflectionHelper {
	// параметризированный метод для доступа к методам HashMap
	public static <T> T callHiddenMethod(HashMap map, String methodName) {
		try {
			// получение метода для конкретного класса
			Method method = map.getClass().getDeclaredMethod(methodName);
			// разрешаю доступ к методу
			method.setAccessible(true);
			// вызываю метод на объекте
			return (T) method.invoke(map);
		} catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored) {
		}
		// если метод не был найден
		return null;
	}
}