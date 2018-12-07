package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
	private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

	public AnyObject get(Long key) {
		SoftReference<AnyObject> softReference = cacheMap.get(key);
		// если сама ссылка не null то получаю StrongReference на объект и возвращаю его значение
		if (softReference != null) return softReference.get();
		return null; // иначе возвращаю null
	}

	public AnyObject put(Long key, AnyObject value) {
		SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
		// если в мэпе до этого ничего не было под данным key
		if (softReference == null) return null;
		// если же там что-то было то достаю StrongReference на объект
		AnyObject anyObject = softReference.get();
		// очищаю мягкую ссылку
		softReference.clear();
		return anyObject;
	}

	public AnyObject remove(Long key) {
		SoftReference<AnyObject> softReference = cacheMap.remove(key);
		if (softReference == null) return null;
		AnyObject anyObject = softReference.get();
		softReference.clear();
		return anyObject;
	}
}