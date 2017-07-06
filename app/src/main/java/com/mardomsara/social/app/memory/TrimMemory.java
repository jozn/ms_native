package com.mardomsara.social.app.memory;

import com.facebook.common.memory.MemoryTrimType;

import static android.content.ComponentCallbacks2.*;

/**
 * Created by Hamid on 7/2/2017.
 */

public class TrimMemory {
	public static void trimFromActivities(int level){
		switch (level){
			case TRIM_MEMORY_COMPLETE:
				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
				break;
			case TRIM_MEMORY_MODERATE:
//				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.);
				break;
			case TRIM_MEMORY_BACKGROUND:
				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnAppBackgrounded);
				break;
			case TRIM_MEMORY_UI_HIDDEN:
				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnAppBackgrounded);
				break;
			case TRIM_MEMORY_RUNNING_CRITICAL:
				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnCloseToDalvikHeapLimit);
				break;
			case TRIM_MEMORY_RUNNING_LOW:
				MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
				break;
			case TRIM_MEMORY_RUNNING_MODERATE:
				break;

		}
	}

	public static void trimLow(){
		MemoryTrimmerRegistry.getInsatnce().trimAll(MemoryTrimType.OnSystemLowMemoryWhileAppInForeground);
	}
}
