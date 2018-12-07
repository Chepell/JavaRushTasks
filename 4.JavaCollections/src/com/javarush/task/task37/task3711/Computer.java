package com.javarush.task.task37.task3711;

/**
 * Artem Voytenko
 * 02.12.2018
 */

public class Computer {
	private CPU cpu;
	private Memory ram;
	private HardDrive hdd;

	public Computer() {
		cpu = new CPU();
		ram = new Memory();
		hdd = new HardDrive();
	}

	public void run() {
		cpu.calculate();
		ram.allocate();
		hdd.storeData();
	}
}
