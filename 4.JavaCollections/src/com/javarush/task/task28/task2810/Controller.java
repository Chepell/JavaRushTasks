package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

import java.util.Arrays;

/**
 * Artem Voytenko
 * 08.12.2018
 */

// в нем будет содержаться бизнес логика
public class Controller {
	private Provider[] providers;

	public Controller(Provider ... providers) {
		if (providers == null || providers.length == 0) {
			throw new IllegalArgumentException();
		}
		this.providers = providers;
	}

	@Override
	public String toString() {
		return "Controller{" +
				"providers=" + Arrays.toString(providers) +
				'}';
	}
}
