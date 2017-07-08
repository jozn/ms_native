package com.mardomsara.social.models.realm_play;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
public class Blog extends RealmObject {

	@PrimaryKey
	private String Id;
	private String Name;
	private int Age;

	public static void play() {
		Realm realm = Realm.getDefaultInstance();

//		BlogRealmProxy
//		realm.where(Blog.class).lessThan("", 25).findAll().
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		this.Age = age;
	}


}