package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
	public static void main(String[] args) throws IOException {
		String file = args[0];

		Set<Character> set = getSet(file);
		printSymbols(set);

	}


	public static Set<Character> getSet(String filePath) {
		Path path = Paths.get(filePath);
		Set<Character> set = new TreeSet<>();
		try (InputStream inputStream = Files.newInputStream(path)) {
			char ch;
			while (inputStream.available() != 0) {
				int symb = inputStream.read();
				if ((symb >= 65 && symb <= 90) || (symb >= 97 && symb <= 122)) {
					ch = (char) symb;
					char c = Character.toLowerCase(ch);
					set.add(c);
				}
			}
		} catch (IOException e) {
			System.out.println("File doesn't found!");
		}
		return set;
	}

	public static void printSymbols(Set<Character> set) {
		Iterator<Character> iterator = set.iterator();
		int count = 0;
		while (iterator.hasNext() && count < 5) {
			System.out.print(iterator.next());
			count++;
		}
	}
}
