package com.example.objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MySecrets {
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("host")
	private String host;
	@JsonProperty("engine")
	private String engine;
	@JsonProperty("port")
	private Number port;
	@JsonProperty("dbClusterIdentifier")
	private String dbClusterIdentifier;
	@JsonProperty("ssl")
	private boolean ssl;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public Number getPort() {
		return port;
	}

	public void setPort(Number port) {
		this.port = port;
	}

	public String getDbClusterIdentifier() {
		return dbClusterIdentifier;
	}

	public void setDbClusterIdentifier(String dbClusterIdentifier) {
		this.dbClusterIdentifier = dbClusterIdentifier;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}

}
