package com.javarush.task.task36.task3606;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
	private List<Class> hiddenClasses = new ArrayList<>();
	private String packageName;

	public Solution(String packageName) {
		this.packageName = packageName;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
		solution.scanFileSystem();
		System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplse"));
		System.out.println(solution.getHiddenClassObjectByKey("hiddenclassimplf"));
		System.out.println(solution.getHiddenClassObjectByKey("packa"));
	}

	public void scanFileSystem() {
		// получаю массив файлов в директории
		File[] dir = new File(packageName).listFiles();
		// создаю объект совего класс-лоудера
		ClassFromPath classFromPath = new ClassFromPath();
		// проверяю, что массив не пустой
		if (dir != null) {
			// читаю каждый файл из массива
			for (File filePath : dir) {
				String file = filePath.toString();
				// если это файл класс, то с помощью метода своего загрузчика загружаю класс и добавляю в список
				if (file.endsWith(".class")) hiddenClasses.add(classFromPath.findClass(file));
			}
		}
	}

	// метод фабрика создания объектов с конструктором по умолчанию
	public HiddenClass getHiddenClassObjectByKey(String key) {
		HiddenClass obj = null;
		// цикл по классам в списке
		for (Class<?> clazz : hiddenClasses) {
			// проверяю содержится ли ключ-параметр метода в имени класса
			if (clazz.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
				try {
					// получаю массив конструкторов класса
					Constructor[] constructors = clazz.getDeclaredConstructors();
					// циклом прохожу по всем конструкторам
					for (Constructor constructor : constructors) {
						// получаю массив параметров конструктора, нужен конструктор по умолчанию, без параметров
						if (constructor.getParameterTypes().length == 0) {
							// делаю констурктор доступным
							constructor.setAccessible(true);
							// создаю объект, явно указываю что аргументов нет
							obj = (HiddenClass) constructor.newInstance(null);
							break;
						}
					}
				} catch (Exception e) {
				}
			}
		}
		return obj;
	}
}

// свой класс загрузчика
class ClassFromPath extends ClassLoader {
	// переопределения метода загрузки класса по пути в виде строки
	@Override
	protected Class<?> findClass(String name) {
		Class<?> cl = null;
		try {
			byte[] classInBytes = Files.readAllBytes(Paths.get(name));
			cl = defineClass(null, classInBytes, 0, classInBytes.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cl;
	}
}

