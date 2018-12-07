package com.javarush.task.task38.task3804;

/**
 * Artem Voytenko
 * 06.12.2018
 */

/**
 * Создай класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
 * Этот метод должен принимать один параметр - энум.
 * Если передан энум:
 * * ExceptionApplicationMessage, верни исключение Exception
 * * ExceptionDBMessage, верни исключение RuntimeException
 * * ExceptionUserMessage, верни Error иначе верните IllegalArgumentException без сообщения.
 * <p>
 * В качестве сообщения (message) для каждого возвращаемого объекта используйте элементы энума,
 * в которых все знаки подчеркивания замените на пробелы.
 * Сообщение должно быть в нижнем регистре за исключением первого символа.
 * Например, сообщение для ExceptionApplicationMessage.SOCKET_IS_CLOSED - "Socket is closed".
 */

public class FactoryException {
	public static Throwable getExc(Enum type) {
		if (type == null) return new IllegalArgumentException();

		String msg = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");

		if (type instanceof ExceptionApplicationMessage) {
			return new Exception(msg);
		} else if (type instanceof ExceptionDBMessage) {
			return new RuntimeException(msg);
		} else if (type instanceof ExceptionUserMessage) {
			return new Error(msg);
		} else {
			return new IllegalArgumentException();
		}

	}
}
