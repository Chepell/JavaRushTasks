package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Artem Voytenko
 * 29.11.2018
 */

public class CachingProxyRetriever implements Retriever {
	private LRUCache<Long, Object> cache;
	private OriginalRetriever originalRetriever;

	public CachingProxyRetriever(Storage storage) {
		originalRetriever = new OriginalRetriever(storage);
		cache = new LRUCache<>(16);
	}

	@Override
	public Object retrieve(long id) {
		Object result = cache.find(id);
		if (result == null) {
			result = originalRetriever.retrieve(id);
			cache.set(id, result);
		}
		return result;
	}
}
