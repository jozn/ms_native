package com.mardomsara.social.pipe.util;

import android.support.annotation.Nullable;

import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.helpers.TimeUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/**
 * Created by Hamid on 5/12/2016.
 */
class TimeOutRegistery<K,V extends TimeOutRegistery.Entry<K>> {
	public static interface Entry<K> {
		void onTimeOut();
		void onSuccess();
		long timeOutAtMs();
		K getKey();
	}

	private boolean hasSetInterval = false;
	private Map<K, V>  _mapper2 = Collections.synchronizedMap(new HashMap<>());

	public void register(K key,V handler) {
		_mapper2.put(key, handler);
		setNextChecker();
	}

	@Nullable
	V tryGet(K key) {
		return _mapper2.get(key);
	}

	void clean(K key){
		_mapper2.remove(key);
	}

	private synchronized void setHasSetInterval(boolean val){
		hasSetInterval = val;
	}

	private synchronized boolean getHasSetInterval(){
		return hasSetInterval;
	}

	private  void runErrorOfTimeouts() {
		AppUtil.log(" Pipes runErrorOfTimeouts() ");
		for(V call : _mapper2.values()){
			if(call.timeOutAtMs() < TimeUtil.getTimeMs()){
				try {
					call.onTimeOut();
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					clean(call.getKey());
//					_mapper.remove(call.clientCallId);
				}
			}
		}
	}

	private  void setNextChecker(){
		if(getHasSetInterval()){
			return;
		}
		setHasSetInterval(true);
		Runnable runner  = ()->{
			int n = 0;
			while (n < 5){ // 5 times * 1 second  = 5sec
				try {
					Thread.sleep(1000);
					runErrorOfTimeouts();
				}catch (Exception e){
					e.printStackTrace();
				}
				n++;
			}
			setHasSetInterval(false);
			if(_mapper2.size() >0){
				setNextChecker();
			}
		};
		Executors.newSingleThreadExecutor().execute(runner);
	}

}