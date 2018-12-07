package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
	private Map<K, V> cache = new WeakHashMap<>();

	public V getByKey(K key, Class<V> clazz) throws Exception {
		// достать объект из cache для ключа key
		V v = cache.get(key);
		// Если объекта не существует в кэше
		if (v == null) {
			// то добавьте в кэш новый экземпляр используя рефлексию получить доступ к публичному конструктору
			// с одним параметром типа K
			Constructor<V> constructor = clazz.getConstructor(key.getClass());
			// создать новый экземпляр используя этот конструктор
			v = constructor.newInstance(key);
			// поместить созданный объект в мэп под заданным ключом
			cache.put(key, v);
		}
		// вернуть объект
		return v;
	}

	public boolean put(V obj) {
		try {
			// Используя рефлексию получи ссылку на метод K getKey() с любым модификатором доступа
			Method method = obj.getClass().getDeclaredMethod("getKey");
			// Используя рефлексию разреши к нему доступ
			method.setAccessible(true);
			// Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
			K key = (K) method.invoke(obj);
			// Добавь в кэш пару <key, obj>
			cache.put(key, obj);
			// Метод put должен возвращать true
			return true;
		} catch (Exception ignore) {
			// если метод отработал некорректно на каком-то из этапов, то возвращаю false
			// исключения игнорируются
			return false;
		}
	}

	public int size() {
		return cache.size();
	}
}