package com.github.eventreader.model;

public class EventLog {
	
	private String id;
	private String state;
	private String type;
	private String host;
	private int begintimestamp;
	private int endtimestamp;
	
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
	public int getBegintimestamp() {
		return begintimestamp;
	}
	public void setBegintimestamp(int begintimestamp) {
		this.begintimestamp = begintimestamp;
	}
	public int getEndtimestamp() {
		return endtimestamp;
	}
	public void setEndtimestamp(int endtimestamp) {
		this.endtimestamp = endtimestamp;
	}

}
