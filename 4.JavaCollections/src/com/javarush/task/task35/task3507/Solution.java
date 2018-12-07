package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
	public static void main(String[] args) {
		// параметр метода возвращает строку:
		// /E:/Documents/cloud/Dropbox/JavaRush/JavaRushTasks/out/production/4.JavaCollections/com/javarush/task/task35/task3507/data
		Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath() + Solution.class.getPackage()
				.getName().replaceAll("[.]", "/") + "/data");
		System.out.println(allAnimals);
	}

	public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
		Set<Animal> set = new HashSet<>();
		// из пути к папке получаю массив файлов/папок которые в ней находятся
		File[] list = new File(pathToAnimals).listFiles();
		// создаю экземпляр своего загрузчика
		ClassFromPath cl = new ClassFromPath();
		for (File file : list) {
			// проверка что это файл класса
			if (file.isFile() && file.getName().endsWith(".class")) {
				// используя метод своего загрузчика загружаю класс из его байткода
				Class clazz = cl.findClass(file.toString());
				// проверка что полученный класс является наследником или в данном случае
				// реализует интерфейс Animal, а если нет, то этот файл пропускаю и продолжаю цикл
				if (!Animal.class.isAssignableFrom(clazz)) continue;

				// Циклом иду по массиву всех конструкторов
				for (Constructor constructor : clazz.getConstructors())
					// если у конструктора нет параметров, то это наш, нужный конструктор по умолчанию!
					if (constructor.getParameterCount() == 0) {
						try {
							// тогда создаю объект и помещаю его во множество
							Animal animal = (Animal) clazz.newInstance();
							set.add(animal);
						} catch (InstantiationException | IllegalAccessException e) {
							e.printStackTrace();
						}
					}
			}
		}
		return set;
	}

	// реализация своего загрузчика классов
	public static class ClassFromPath extends ClassLoader {
		// переопределение метода, который принимает путь к файлу класса
		@Override
		protected Class<?> findClass(String name) {
			Class<?> cl = null;
			try {
				byte[] classBytes = Files.readAllBytes(Paths.get(name));
				cl = defineClass(null, classBytes, 0, classBytes.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return cl;
		}
	}
}


