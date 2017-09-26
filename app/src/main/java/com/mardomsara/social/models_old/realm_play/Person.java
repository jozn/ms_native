package com.mardomsara.social.models_old.realm_play;

import io.realm.Realm;
import io.realm.RealmObject;

public class Person extends RealmObject {

	private String id;
	private String name;
	private int age;

	public static void play() {
		Realm realm = Realm.getDefaultInstance();
//		realm.where(Person.class).lessThan("s",2).findAll().
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}