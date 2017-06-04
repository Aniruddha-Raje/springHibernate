package com.blcl.utils;

public class Constants {

	private static Constants constants;

	String serverPort;
	String driverClassName;
	String url;
	String userName;
	String password;

	private Constants() {

	}

	public static Constants getInstance() {

		if (constants == null) {
			synchronized (Constants.class) {
				if (constants == null) {
					constants = new Constants();
				}
			}
		}
		return constants;
	}

	public void init(String serverPort, String driverClassName, String url, String userName, String password) {
		this.serverPort = serverPort;
		this.driverClassName = driverClassName;
		this.url = url;
		this.userName = userName;
		this.password = password;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
