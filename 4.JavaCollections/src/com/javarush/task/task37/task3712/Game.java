package com.javarush.task.task37.task3712;

/**
 * Artem Voytenko
 * 02.12.2018
 */

public abstract class Game {
	public abstract void prepareForTheGame();

	public abstract void playGame();

	public abstract void congratulateWinner();

	public void run() {
		prepareForTheGame();
		playGame();
		congratulateWinner();
	}
}
