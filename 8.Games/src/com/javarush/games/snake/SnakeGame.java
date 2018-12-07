package com.javarush.games.snake;

import com.javarush.engine.cell.*;

/**
 * Artem Voytenko
 * 05.12.2018
 */

public class SnakeGame extends Game {
	public static final int WIDTH = 15;
	public static final int HEIGHT = 15;

	@Override
	public void initialize() {
		setScreenSize(WIDTH, HEIGHT);
//		super.initialize();
	}
}
