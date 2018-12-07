package com.javarush.task.task37.task3709.connectors;

import com.javarush.task.task37.task3709.security.SecurityChecker;
import com.javarush.task.task37.task3709.security.SecurityCheckerImpl;

/**
 * Artem Voytenko
 * 02.12.2018
 * Необходимо создать класс SecurityProxyConnector в пакете connectors,
 * который будет производить проверку безопасности перед подключением.
 * В случае, если проверка не пройдена, соединение не должно быть установлено.
 * <p>
 * Для клиента (в данном случае класс Solution) использование SecurityProxyConnector
 * ничем не должно отличаться от использования класса SimpleConnector.
 * <p>
 * P.S. Тебе понадобятся поля типов SecurityChecker и SimpleConnector в классе SecurityProxyConnector.
 * <p>
 * <p>
 * Требования:
 * 1. В классе SecurityProxyConnector должно быть создано поле типа SimpleConnector.
 * 2. В классе SecurityProxyConnector должно быть создано поле типа SecurityChecker.
 * 3. Конструктор класса SecurityProxyConnector должен принимать один параметр
 * типа String и инициализировать поле типа SimpleConnector.
 * 4. Метод connect класса SecurityProxyConnector должен выполнять проверку
 * безопасности с помощью вызова метода performSecurityCheck у объекта типа SecurityChecker.
 * 5. Если проверка безопасности была пройдена, должно быть выполнено подключение.
 * 6. Если проверка безопасности не была пройдена, подключение не должно быть выполнено.
 * 7. Класс SecurityProxyConnector должен поддерживать интерфейс Connector.
 */

public class SecurityProxyConnector implements Connector {
	private SecurityChecker securityChecker;
	private SimpleConnector simpleConnector;

	public SecurityProxyConnector(String resourceString) {
		simpleConnector = new SimpleConnector(resourceString);
		securityChecker = new SecurityCheckerImpl();
	}

	@Override
	public void connect() {
		if (securityChecker.performSecurityCheck()) {
			simpleConnector.connect();
		}
	}
}
