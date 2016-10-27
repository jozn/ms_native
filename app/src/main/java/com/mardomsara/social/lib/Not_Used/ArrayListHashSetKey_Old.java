package com.mardomsara.social.lib.Not_Used;

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

public class ArrayListHashSetKey_Old<T,K> implements List<T> {


	List<T> data ;
	Map<K,T> map ;
	public ArrayListHashSetKey_Old() {
		data = new ArrayList<T>();
		map = new HashMap<K, T>();
	}

	@Override
	public int size() {
		return data.size();
	}

	@Override
	public boolean isEmpty() {
		return data.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		synchronized (this){
			return map.containsValue(o);
		}
	}

	@NonNull
	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	@NonNull
	@Override
	public Object[] toArray() {
		return data.toArray();
	}

	@NonNull
	@Override
	public <T1> T1[] toArray(T1[] a) {
		return data.toArray(a);
	}

	@Override
	public boolean add(T item) {
		boolean res = false;
		synchronized (this){
			try {
				K key = getKey(item);
				if(item == null || key == null) return false;
				map.put(getKey(item),item);
//				res = data.re(item);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public boolean remove(Object o) {
		boolean res = false;
		synchronized (this){
			try {
				T t = (T) o;
				map.remove(getKey(t));
				res = data.remove(t);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;

//		throw new IllegalAccessError("Can not use thi methd use: ");
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean res = false;
		synchronized (this){
			try {
				res = data.containsAll(c);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean res = false;
		if(c == null)return false;
		synchronized (this){
			try {
				for(Object _c :c){
					map.put(getKey((T) _c),(T)_c);
				}
				res = data.addAll(c);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		boolean res = false;
		if(c == null)return false;
		synchronized (this){
			try {
				for(Object _c :c){
					map.put(getKey((T) _c),(T)_c);
				}
				res = data.addAll(index,c);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		boolean res = false;
		synchronized (this){
			try {
				for(Object _c :c){
					map.remove(getKey((T) _c));
				}
				res = data.removeAll(c);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new IllegalAccessError("Can not use thi methd use: ");
//		return false;
	}

	@Override
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

	@Override
	public T get(int index) {
		synchronized (this){
			try {
				T item = data.get(index);
				if(map.get(getKey(item)) == item){
					return item;
				}
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public T set(int index, T element) {
		synchronized (this){
			try {
				map.put(getKey(element),element);
				return data.set(index,element);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void add(int index, T element) {

	}

	@Override
	public T remove(int index) {
		return null;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;
	}

	@NonNull
	@Override
	public ListIterator<T> listIterator(int index) {
		return null;
	}

	@NonNull
	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return null;
	}

	@Override
	public Spliterator<T> spliterator() {
		return null;
	}

	@Override
	public void replaceAll(UnaryOperator<T> operator) {

	}

	@Override
	public void sort(Comparator<? super T> c) {

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
