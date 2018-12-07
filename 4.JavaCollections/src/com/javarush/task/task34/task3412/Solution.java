package com.javarush.task.task34.task3412;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/* 
Добавление логирования в класс
*/

public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    private int value1;
    private String value2;
    private Date value3;

    public Solution(int value1, String value2, Date value3) {
        this.value1 = value1;
		this.value2 = value2;
		this.value3 = value3;
		logger.debug("initiate values", value1, value2, value3);
	}

    public static void main(String[] args) {
		Solution solution = new Solution(10, "0", new Date());
		solution.divide(10, 0);
	}

    public void calculateAndSetValue3(long value) {
        value -= 133;
		if (value > Integer.MAX_VALUE) {
			logger.trace("value > Integer.MAX_VALUE");
			value1 = (int) (value / Integer.MAX_VALUE);
			logger.debug("change value1", value1);
		} else {
			value1 = (int) value;
			logger.debug("change value1", value1);
		}
	}

    public void printString() {
        if (value2 != null) {
            System.out.println(value2.length());
        }
        logger.trace("value2 is null");
    }

    public void printDateAsLong() {
        if (value3 != null) {
            System.out.println(value3.getTime());
        }
		logger.trace("value3 is null");
	}

    public void divide(int number1, int number2) {
        try {
            System.out.println(number1 / number2);
        } catch (ArithmeticException e) {
			logger.trace("divide exception");
			logger.error("divide error", e);
		}
    }

    public void setValue1(int value1) {
        this.value1 = value1;
        logger.debug("change value1", value1);
    }

    public void setValue2(String value2) {
        this.value2 = value2;
		logger.debug("change value2", value2);
	}

    public void setValue3(Date value3) {
        this.value3 = value3;
		logger.debug("change value3", value3);
	}
}

//Посмотри где бы ты в классе Solution применил какой уровень логирования?
//
//В класс Solution нужно добавить вызовы методов уровня:
//error - 1 раз;
//debug - 6 раз - используй при изменениях значений полей класса;
//trace - 4 раза - используй для отслеживания пути выполнения програмы;
//Сообщения в логах старайся писать информативные.
//Остальной код не изменяй.
//
//
//Требования:
//1. В классе Solution должно существовать приватное статическое финальное поле logger.
//2. Добавь логирование уровня error один раз.
//3. Добавь логирование уровня debug шесть раз.
//4. Добавь логирование уровня trace четыре раза.
