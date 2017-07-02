package com.mardomsara.social.app.fresco;

import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestLoggingListener;
import com.mardomsara.social.app.memory.MemoryTrimmerRegistry;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Hamid on 7/2/2017.
 */

public class FrescoConfig {

	public static void init(Context context){
		context = context.getApplicationContext();

		Set<RequestListener> requestListeners = new HashSet<>();
		requestListeners.add(new RequestLoggingListener());
		ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context)
			// other setters
			.setRequestListeners(requestListeners)
			.setMemoryTrimmableRegistry(MemoryTrimmerRegistry.getInsatnce())
			.build();
		Fresco.initialize(context, config);

	}


	private static void play(Context context){
//		ImagePipelineConfig config = ImagePipelineConfig.newBuilder(context);

//		Fresco.

//		config.getMemoryTrimmableRegistry()
	}

}
