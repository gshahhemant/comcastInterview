package com.helloworld.model;

import java.io.Serializable;

/**
 * @author Hemant Shah
 */

public class ExternalUser implements Serializable {

	private static final long serialVersionUID = 421376107126832008L;

	private int id;
	private int userId;
	private String title;
	private String  body;


	public ExternalUser() {

	}

	public ExternalUser(int id, int userId, String title, String body) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
