package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Instant;
import java.util.*;

/* 
Древний Рим
*/

/**
 * Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
 * Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией...
 * <p>
 * В общем, мне нужен метод romanToInteger, который будет
 * конвертировать число в римской системе счисления {I, V, X, L, C, D, M} в десятичную.
 * Иначе никак не разобрать что и когда у них происходило.
 * <p>
 * <p>
 * Требования:
 * 1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
 * 2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
 * 3. Метод romanToInteger должен быть публичным.
 * 4. Метод romanToInteger должен быть статическим.
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input a roman number to be converted to decimal: ");
		String romanString = bufferedReader.readLine();
		System.out.println("Conversion result equals " + romanToInteger(romanString));
	}

	public static int romanToInteger(String s) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('M', 1000);
		map.put('D', 500);
		map.put('C', 100);
		map.put('L', 50);
		map.put('X', 10);
		map.put('V', 5);
		map.put('I', 1);

		// перевожу строку в верхний регистр
		s = s.toUpperCase();
		int length = s.length();
		// начинаю считать справа, последняя цифра всегда прибавляется
		int resultNum = map.get(s.charAt(length - 1));        // присваиваем ласт элемент
		// и циклом иду до начала строки
		for (int i = length - 1; i > 0; i--) {              // идем с конца
			// с помощью мапа конвертирую значения левого и правого символов в числа
			int leftInt = map.get(s.charAt(i - 1));
			int rightInt = map.get(s.charAt(i));
			// если левый символ больше либо равен правого то добавляю его в сумму
			if (leftInt >= rightInt) {
				resultNum += leftInt;
			} else {
				resultNum -= leftInt;
			}
		}
		return resultNum;
	}
}
