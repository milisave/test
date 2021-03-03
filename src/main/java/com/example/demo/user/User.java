package com.example.demo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "users")
public class User {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long userId;
	
	@Column(name = "account_id")
	private long accountId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	private int type;
	
	@Column(name = "description")
	private String description;
	

	public User() {}
	
	public User(long userId, String name, int type, String description) {
		this.userId = userId;
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
	public User(String name, int type, String description) {
		this.name = name;
		this.type = type;
		this.description = description;
	}


	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "User [userId=" + userId + ", accountId=" + accountId + ", name=" + name + ", type=" + type
				+ ", description=" + description + "]";
	}

}
