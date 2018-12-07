package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Artem Voytenko
 * 27.11.2018
 * *
 * * 9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл.
 * * Учти, каждый entry может содержать еще один entry.
 * * 9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
 * * 9.4.4. void remove() - удалять файл на который указывает path.
 * * Конструктор и методы не должны кидать исключения.
 * *
 * *
 * * Требования:
 * * 3. Метод getFileSize должен возвращать размер файла на который указывает path.
 * * 4. Метод putEntry должен сериализовывать полученный объект типа Entry в файл на который указывает path,
 * * чтобы получить OutputStream используй метод Files.newOutputStream.
 * * 5. Метод getEntry должен десериализовывать объект типа Entry из файл на который указывает path,
 * * чтобы получить InputStream используй метод Files.newInputStream.
 * * 6. Метод remove должен удалять файл на который указывает path с помощью метода Files.delete().
 */

public class FileBucket {
	Path path;

	public FileBucket() {
		try {
			path = Files.createTempFile(null, null);
			Files.deleteIfExists(path);
			Files.createFile(path);
		} catch (IOException e) {
			ExceptionHandler.log(e);
		}
		path.toFile().deleteOnExit();
	}

	public long getFileSize() {
		long size = 0;
		try {
			size = Files.size(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return size;
	}

	public void putEntry(Entry entry) {
		try (OutputStream outputStream = Files.newOutputStream(path);
			 ObjectOutputStream oos = new ObjectOutputStream(outputStream)) {
			oos.writeObject(entry);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Entry getEntry() {
		Entry entry = null;
		if (getFileSize() != 0) {
			try (InputStream inputStream = Files.newInputStream(path);
				 ObjectInputStream ois = new ObjectInputStream(inputStream)) {
				entry = (Entry) ois.readObject();
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return entry;
	}

	public void remove() {
		try {
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
