package com.javarush.task.task38.task3811;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Artem Voytenko
 * 07.12.2018
 * <p>
 * Реализуй в отдельном файле аннотацию Ticket.
 * <p>
 * Требования к ней следующие:
 * 1) Должна быть публичная и доступна во время выполнения программы.
 * 2) Применяться может только к новым типам данных
 * (Class, interface (including annotation type), or enum declaration).
 * 3) Должна содержать enum Priority c элементами LOW, MEDIUM, HIGH.
 * 4) Приоритет будет задавать свойство priority - по умолчанию Priority.MEDIUM.
 * 5) Свойство tags будет массивом строк и будет хранить теги связанные с тикетом.
 * 6) Свойство createdBy будет строкой - по умолчанию Amigo.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface Ticket {
	Priority priority() default Priority.MEDIUM;

	String[] tags() default {};

	String createdBy() default "Amigo";


	enum Priority {
		LOW,
		MEDIUM,
		HIGH,
	}
}



