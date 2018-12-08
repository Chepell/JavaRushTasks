package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

/**
 * Artem Voytenko
 * 08.12.2018
 */

public class Aggregator {
	public static void main(String[] args) {
		Provider provider = new Provider(new Strategy() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		Controller controller = new Controller(provider);

		System.out.println(controller);
	}
}
