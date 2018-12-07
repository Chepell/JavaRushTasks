package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @autor Artem Voytenko
 */

@XmlType(name = "shop")
@XmlRootElement
public class Shop {
	public Goods goods;
	public int count;
	public double profit;
	public String[] secretData;

	public static class Goods {
		@XmlElement(name = "names")
		List<String> names = new ArrayList<>();
	}

	@Override
	public String toString() {
		return "Shop{" +
				"goods=" + goods.names +
				", count=" + count +
				", profit=" + profit +
				", secretData=" + Arrays.toString(secretData) +
				'}';
	}
}

//1. Класс Shop должен быть создан в отдельном файле.
//2. В классе Shop должно быть создано поле goods типа Goods.
//3. В классе Shop должно быть создано поле count типа int.
//4. В классе Shop должно быть создано поле profit типа double.
//5. В классе Shop должен быть создан массив строк secretData.
//6. В классе Shop должен содержаться вложенный статический класс Goods.
//7. В классе Shop.Goods должен быть создан список строк names.
//8. Все поля класса Shop должны быть публичными.
//9. Метод getClassName класса Solution должен возвращать класс Shop.
