package com.drvcorp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logs")
public class Log {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="datails")
	private String datails;
	
	@Column(name="username")
	private String username;
	
	@Column(name="url")
	private String url;

	public Log() {
		
	}	
	public Log(Date date, String datails, String username, String url) {
		this.date = date;
		this.datails = datails;
		this.username = username;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDatails() {
		return datails;
	}

	public void setDatails(String datails) {
		this.datails = datails;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
