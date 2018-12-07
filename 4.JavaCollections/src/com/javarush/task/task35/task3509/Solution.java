package com.javarush.task.task35.task3509;

import java.util.*;
import java.util.stream.Collectors;


/* 
Collections & Generics
*/
public class Solution {

	public static void main(String[] args) {
	}

	//Методы newArrayList, newHashSet параметризируй типом T.
	public static <T> ArrayList<T> newArrayList(T... elements) {
		return new ArrayList<>(Arrays.asList(elements));
	}

	public static <T> HashSet<T> newHashSet(T... elements) {
		//напишите тут ваш код
		return (HashSet<T>) Arrays.stream(elements).collect(Collectors.toSet());
	}

	// Аргументы метода newHashMap должны принимать списки, в которых содержатся наследники типов K и V.
	public static <K, V> HashMap<K, V> newHashMap(List<? extends K> keys, List<? extends V> values) {
		if (keys.size() != values.size()) throw new IllegalArgumentException();
		HashMap<K, V> hashMap = new HashMap<>();
		for (int i = 0; i < keys.size(); i++) {
			hashMap.put(keys.get(i), values.get(i));
		}
		return hashMap;
	}
}