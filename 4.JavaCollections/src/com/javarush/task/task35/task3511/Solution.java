package com.javarush.task.task35.task3511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* 
Wildcards для коллекций
*/
public class Solution {

	public static void main(String[] args) {
		List<Long> integers = Arrays.asList(12L, 56L, 78L, -46L);
		List<Double> doubles = Arrays.asList(12.0, 56.78, 78.13, -46.065);
		List<String> list = Arrays.asList("fd", "vvdf65", "ds2", "-56.61");

		Double sum = sum(integers);
		String concat = concat(list);

		System.out.println(concat);
	}

	public static Double sum(List<? extends Number> list) {
		Double result = 0.0;
		for (int i = 0; i < list.size(); i++) {
			Number numb = list.get(i);
			result += numb.doubleValue();
		}
		return result;
	}

	public static Double multiply(List<? extends Number> list) {
		Double result = 1.0;
		for (int i = 0; i < list.size(); i++) {
			Number numb = list.get(i);
			result *= numb.doubleValue();
		}
		return result;
	}

	public static String concat(List<?> list) {
		StringBuilder builder = new StringBuilder();
		for (Object obj : list) {
			builder.append(obj);
		}
		return builder.toString();
	}

	public static <E> List<E> combine(List<? extends Collection> list) {
		List<E> result = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			Collection collection = list.get(i);
			result.addAll(collection);
		}
		return result;
	}
}
