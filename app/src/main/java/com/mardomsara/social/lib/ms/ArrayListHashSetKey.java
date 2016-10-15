package com.mardomsara.social.lib.ms;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mardomsara.social.helpers.AndroidUtil;
import com.mardomsara.social.helpers.AppUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.UnaryOperator;

/**
 * Created by Hamid on 10/13/2016.
 */

public class ArrayListHashSetKey<T extends Comparable ,K> {

	List<T> data ;
	Map<K,T> map ;
	public ArrayListHashSetKey(@NonNull KeyGen<T,K> gen) {
		data = new ArrayList<T>(30);
		map = new HashMap<K, T>(30);
		set_keyGen(gen);
	}

	public ArrayListHashSetKey(@NonNull KeyGen<T,K> gen,Comparator<T> sorter) {
		this(gen);
		set_sorter(sorter);
	}

	public int size() {
		AppUtil.log("size:"+map.size()+ " "+ data.size());

		return data.size();
	}


	public boolean isEmpty() {
		return data.isEmpty();
	}

	public boolean contains(T o) {
		synchronized (this){
			return map.containsValue(o);
		}
	}

	public boolean containsKey(K key) {
		synchronized (this){
			return map.containsKey(key);
		}
	}

	@NonNull
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@NonNull
	public Object[] toArray() {
		return data.toArray();
	}

	@NonNull

	public <T1> T1[] toArray(T1[] a) {
		return data.toArray(a);
	}


	public boolean addStart(T item) {
		boolean res = false;
		synchronized (this){
			try {
				K key = getKey(item);
				if(item == null || key == null) return false;
				if(map.containsKey(key)){
					return false;
				}
				map.put(getKey(item),item);
				data.add(0,item);
				return true;
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	public boolean addEnd(T item) {
		boolean res = false;
		synchronized (this){
			try {
				K key = getKey(item);
				if(item == null || key == null) return false;
				if(map.containsKey(key)){
					return false;
				}
				map.put(getKey(item),item);
//				data.add(data.size(),item);
				data.add(item);//ArrayList add(e) adds to end
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	public boolean replace(T item) {
		boolean res = false;
		synchronized (this){
			try {
				K key = getKey(item);
				if(item == null || key == null) return false;
				if(!map.containsKey(key)){
					return false;
				}
				map.put(getKey(item),item);
				int index = indexOf(item);
				if(index >= 0){
					data.set(index,item);
				}

			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}


	public boolean remove(T item) {
		boolean res = false;
		synchronized (this){
			try {
				map.remove(getKey(item));
				res = data.remove(item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	public boolean removeKey(K key) {
		boolean res = false;
		synchronized (this){
			try {
				T item = map.get(key);
				map.remove(key);
				res = data.remove(item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	public boolean containsAllItems(Collection<T> items) {
		synchronized (this){
			try {
				for(T item : items){
					if (! map.containsKey(getKey(item))){
						return false;
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}

	public boolean containsAllKeys(Collection<K> keys) {
		synchronized (this){
			try {
				for(K key : keys){
					if (! map.containsKey(key)){
						return false;
					}
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return true;
	}


	public boolean addAllStart(Collection<? extends T> items) {
		synchronized (this){
			try {
				for(T item :items){
					addStart(item);
				}
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean addAllEnd(Collection<? extends T> items) {
		synchronized (this){
			try {
				for(T item :items){
					addEnd(item);
				}
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean removeAll(Collection<T> items) {
		synchronized (this){
			try {
				for(T item :items){
					remove(item);
				}
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public boolean removeAllKeys(Collection<K> keys) {
		synchronized (this){
			try {
				for(K key :keys){
					removeKey(key);
				}
			}catch (Exception e){
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}


	public void clear() {
		synchronized (this){
			try {
				map.clear();
				data.clear();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}


	public T get(int index) {
		synchronized (this){
			try {
				return data.get(index);
//				if(map.get(getKey(item)) == item){
//					return item;
//				}
			}catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}

	public Set<K> getKeys() {
		synchronized (this){
			try {
				return map.keySet();
//				if(map.get(getKey(item)) == item){
//					return item;
//				}
			}catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}

	@Nullable
	public T getByKey(K key) {
		synchronized (this){
			try {
				return map.get(key);
			}catch (Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}

	public T setOrReplace(int index, T item) {
		synchronized (this){
			try {
				T itemOld = map.get(getKey(item));
				map.put(getKey(item),item);
				data.remove(itemOld);
				data.add(index,item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	public void remove(int index) {
		synchronized (this){
			try {
				T item = data.get(index);
				if(item == null)return;
				map.remove(getKey(item));
				remove(item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}


	public int indexOf(T item) {
		return data.indexOf(item);
	}

	public int indexOfByKey(K key) {
		T item = map.get(key);
		if(item == null) return -1;
		return data.indexOf(item);
	}


	public int lastIndexOf(Object item) {
		return data.lastIndexOf(item);
	}


	public void replaceAll(UnaryOperator<T> operator) {

	}


	private void sort(Comparator<? super T> c) {

	}

	public void fromList(List<T> list) {
		if(list == null)return;
		for(T item: list){
			addEnd(item);
		}

	}

	Comparator<T> sorter;
	public void set_sorter(Comparator<T> gen){
		sorter = gen;
	}
	public void sort(){
		Collections.sort(data);
//		Collections.sort(data,sorter);
	}

	//////////// Me /////////////
	K getKey(T item){
		return _keyGen.gen(item);
	}

	KeyGen<T,K> _keyGen;
	public void set_keyGen(KeyGen<T,K> gen){
		_keyGen = gen;
	}

	public interface KeyGen<P, G> {
		G gen(P obj);
	}
}
