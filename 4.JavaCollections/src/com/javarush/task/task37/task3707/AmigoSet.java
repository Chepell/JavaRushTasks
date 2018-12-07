package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {
	private static final Object PRESENT = new Object();
	private transient HashMap<E, Object> map;

	public AmigoSet() {
		this.map = new HashMap<>();
	}

	public AmigoSet(Collection<? extends E> collection) {
		int capacity = (int) Math.max(16, Math.ceil(collection.size() / .75f));
		this.map = new HashMap<>(capacity);
		this.addAll(collection);
	}

	@Override
	public boolean add(E e) {
		if (map.containsKey(e)) {
			return false;
		} else {
			map.put(e, PRESENT);
			return true;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return map.keySet().iterator();
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return map.containsKey(o);
	}


	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean remove(Object o) {
		return map.remove(o) != null;
	}

	@Override
	public Object clone() {
		try {
			// поверхностное клонирование всего объекта в новую переменную
			AmigoSet<E> amigoSet = (AmigoSet<E>) super.clone();
			// кланирование мэпа в соответсвующее поле нового объекта
			amigoSet.map = (HashMap) map.clone();
			return amigoSet;
		} catch (Exception e) { // словить одно исключение
			throw new InternalError(e); // и выбросить другое
		}
	}

	// переписываю методы автоматической сериализации
	private void writeObject(ObjectOutputStream outputStream) throws IOException {
		// вызов метода сериализаци всего объекта по умолчанию (без статик и транзиент)
		outputStream.defaultWriteObject();
		// вызываю методы HashMap с помощью вспомогательного метода класса через рефлексию
		outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "loadFactor"));
		outputStream.writeObject(HashMapReflectionHelper.callHiddenMethod(map, "capacity"));
		outputStream.writeObject(map.size());
		// каждый ключ пишу как отдельный объект
		for(Map.Entry<E, Object> pair : map.entrySet()){
			outputStream.writeObject(pair.getKey());
		}
		outputStream.close();
	}

	private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
		// вызов метода десериализации по умолчанию
		inputStream.defaultReadObject();
		// вычитываю переменные для конструктора мэпа
		float loadFactor = (float) inputStream.readObject();
		int capacity = (int) inputStream.readObject();
		// и размер мэпа
		int size = (int) inputStream.readObject();
		// создаю мэп с заданными параметрами используя спецконструктор
		map = new HashMap<>(capacity, loadFactor);
		// в цикле вычитываю объекты и ключом добавляю в мэп
		for (int i = 0; i < size; i++) {
			map.put((E) inputStream.readObject(), PRESENT);
		}
		inputStream.close();
	}
}