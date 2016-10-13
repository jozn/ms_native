package com.mardomsara.social.lib.ms;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.UnaryOperator;

/**
 * Created by Hamid on 10/13/2016.
 */

public class ArrayListHashSetKey<T,K> {


	List<T> data ;
	Map<K,T> map ;
	public ArrayListHashSetKey() {
		data = new ArrayList<T>();
		map = new HashMap<K, T>();
	}

	public int size() {
		return map.size();
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


	public boolean add(T item) {
		boolean res = false;
		synchronized (this){
			try {
				K key = getKey(item);
				if(item == null || key == null) return false;
				if(map.containsKey(key)){
					return false;
				}
				map.put(getKey(item),item);
				res = data.add(item);
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


	public boolean addAll(Collection<? extends T> items) {
		synchronized (this){
			try {
				for(T item :items){
					add(item);
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

	public T set(int index, T element) {
		synchronized (this){
			try {
				map.put(getKey(element),element);
				data.remove(element);
				return data.set(index,element);
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
				remove(item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}


	public int indexOf(T item) {
		return data.indexOf(item);
	}


	public int lastIndexOf(Object item) {
		return data.lastIndexOf(item);
	}


	public void replaceAll(UnaryOperator<T> operator) {

	}


	private void sort(Comparator<? super T> c) {

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
