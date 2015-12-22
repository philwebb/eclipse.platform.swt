package org.eclipse.swt.graphics;

import java.util.*;

/**
 * Simple {@link GCTextData} cache limited to a set number of items.
 */
class GCTextDataCache {

	private final int cacheSize;
	private final Map<String, GCTextData> cache = new LinkedHashMap<String, GCTextData>() {

		private static final long serialVersionUID = 1L;

		@Override
		protected boolean removeEldestEntry(Map.Entry<String, GCTextData> eldest) {
			if (size() >= cacheSize) {
				((GCTextData) eldest.getValue()).release();
				return true;
			}
			return false;
		};
	};

	public GCTextDataCache(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public void release() {
		for (GCTextData data : cache.values()) {
			data.release();
		}
		cache.clear();
	}

	public GCTextData get(String string) {
		return cache.get(string);
	}

	public void put(String string, GCTextData data) {
		cache.put(string, data);
	}

}
