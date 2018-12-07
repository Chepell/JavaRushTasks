package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
	static final long serialVersionUID = 123456789L;
	private HashMap<K, List<V>> map;
	private int repeatCount;

	public MyMultiMap(int repeatCount) {
		this.repeatCount = repeatCount;
		map = new HashMap<>();
	}

	/**
	 * int size() - должен возвращать количество значений в нашей коллекции.
	 */
	@Override
	public int size() {
		int size = 0;
		// прохожу по всем key коллекции и суммирую размеры List в value
		for (Entry<K, List<V>> pair : map.entrySet()) {
			size += pair.getValue().size();
		}
		return size;
	}

	/**
	 * V put(K key, V value) - должен добавить элемент value по ключу key.
	 * Если в мапе такой ключ уже есть, и количество значений по этому ключу меньше,
	 * чем repeatCount - то добавь элемент value в конец листа в объекте map.
	 * Если по такому ключу количество значений равняется repeatCount - то удали
	 * из листа в объекте map элемент с индексом ноль, и добавь в конец листа value.
	 * Метод должен возвращать значение последнего добавленного элемента по ключу key
	 * (но не значение, которое мы сейчас добавляем). Если по ключу key значений еще нет - верни null.
	 */
	@Override
	public V put(K key, V value) {
		// создаю переменную под значение value
		V lastValue = null;
		// если в мэпе есть такой ключ
		if (map.containsKey(key)) {
			// то вытаскиваю value по ключу в виде списка
			List<V> listForKey = map.get(key);
			// и сразу сохраняю в переменную текущее последнее значение из списка
			lastValue = listForKey.get(listForKey.size() - 1);
			// если в списке элементов меньше чем разрешено в поле объекта класса при создании
			if (listForKey.size() < repeatCount) {
				// добавляю в конец списка новое значение
				listForKey.add(value);
				// если же в списке элементов столько же сколько максимально разрешено
			} else {
				// удаляю первый элемент из головы списка
				listForKey.remove(0);
				// и добавляю новый элемент в конец списка
				listForKey.add(value);
			}
		} else { // если же в мэпе еще нет такого ключа
			// создаю список под value и сразу помещаю в него один едиснтвенный элемент
			List<V> valueList = new ArrayList<>(Collections.singletonList(value));
			// помещаю пару в мэп
			map.put(key, valueList);
		}
		// возвращаю предыдущий последний элемент
		return lastValue;
	}

	/**
	 * 3) V remove(Object key) - должен удалить элемент по ключу key.
	 * Если по этому ключу хранится несколько элементов - должен удаляться элемент из листа с индексом ноль.
	 * Если по какому-то ключу хранится лист размером ноль элементов - удали такую пару ключ : значение.
	 * Метод должен возвращать элемент, который ты удалил. Если в мапе нет ключа key - верни null.
	 * <p>
	 * Метод remove должен удалить элемент по ключу key, если по ключу key в мапе имеются значения.
	 * Если по этому ключу хранится несколько элементов - должен удаляться элемент из листа с индексом ноль.
	 * Если после удаления по ключу хранится лист размером ноль элементов - удали такую пару ключ : лист.
	 */
	@Override
	public V remove(Object key) {
		V lastValue = null;
		if (map.containsKey(key)) {
			List<V> listForKey = map.get(key);
			if (listForKey.size() > 1) {
				lastValue = listForKey.remove(0);
			} else {
				lastValue = listForKey.remove(0);
				map.remove(key);
			}
		}
		return lastValue;
	}

	/**
	 * Set<K> keySet() - должен вернуть сет всех ключей, которые есть в мапе map.
	 */
	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	/**
	 * Collection<V> values() - должен вернуть ArrayList<V> всех значений.
	 * Порядок значений в листе не имеет значения.
	 */
	@Override
	public Collection<V> values() {
		Collection<V> resultCol = new ArrayList<>();
		for (Entry<K, List<V>> entry : map.entrySet()) {
			List<V> valueList = entry.getValue();
			if (valueList.size() != 0) {
				for (V v : valueList) {
					if (v != null) resultCol.add(v);
				}
			}
		}
		return resultCol;
	}

	/**
	 * boolean containsKey(Object key) - должен вернуть true, если в мапе присутствует ключ key, иначе вернуть false.
	 */
	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	/**
	 * boolean containsValue(Object value) - должен вернуть true,
	 * если в мапе присутствует значение value, иначе вернуть false.
	 */
	@Override
	public boolean containsValue(Object value) {
		for (Entry<K, List<V>> pair : map.entrySet()) {
			List<V> valueList = pair.getValue();
			if (valueList.contains(value)) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{");
		for (Map.Entry<K, List<V>> entry : map.entrySet()) {
			sb.append(entry.getKey());
			sb.append("=");
			for (V v : entry.getValue()) {
				sb.append(v);
				sb.append(", ");
			}
		}
		String substring = sb.substring(0, sb.length() - 2);
		return substring + "}";
	}
}