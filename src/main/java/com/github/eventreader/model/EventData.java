package com.github.eventreader.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "customers")
public class EventData {
	
	@Id
	private String id;
	private String state;
	private String type;
	private String host;
	private int duration;
	private boolean alert;
	
	public EventData(String id, String state, String type, String host, int duration, boolean alert) {
		super();
		this.id = id;
		this.state = state;
		this.type = type;
		this.host = host;
		this.duration = duration;
		this.alert = alert;
	}
	
	
	public EventData() {
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAlert() {
		return alert;
	}
	public void setAlert(boolean alert) {
		this.alert = alert;
	}
	

}
