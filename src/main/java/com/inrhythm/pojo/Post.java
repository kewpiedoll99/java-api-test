package com.inrhythm.pojo;

import java.io.Serializable;

// singular name preferred IMO for individual object
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer userId; // allow for nulls
	private int id;
	private String title;
	private String body;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
