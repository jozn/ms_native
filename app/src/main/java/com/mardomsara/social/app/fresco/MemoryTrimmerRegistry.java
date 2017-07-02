package com.mardomsara.social.app.fresco;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hamid on 7/2/2017.
 */

public class MemoryTrimmerRegistry implements MemoryTrimmableRegistry {
	private static MemoryTrimmerRegistry instance;
	Set<MemoryTrimmable> set = new HashSet<>();

	private MemoryTrimmerRegistry() {

	}

	public static MemoryTrimmerRegistry getInsatnce() {
		if (instance == null) {
			instance = new MemoryTrimmerRegistry();
		}
		return instance;
	}

	@Override
	public void registerMemoryTrimmable(MemoryTrimmable trimmable) {
		set.add(trimmable);
	}

	@Override
	public void unregisterMemoryTrimmable(MemoryTrimmable trimmable) {
		set.remove(trimmable);
	}

	public void trimAll(MemoryTrimType trimType) {
		set.forEach(t -> t.trim(trimType));
	}
}
