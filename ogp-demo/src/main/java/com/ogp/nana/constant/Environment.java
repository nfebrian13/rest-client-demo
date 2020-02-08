package com.ogp.nana.constant;

public enum Environment {

	BNI("https://apidev.bni.co.id:8067/api/oauth/token"), 
	SIT("https://sit.domain.com:2019/"), 
	CIT("https://cit.domain.com:8080/"),
	DEV("https://dev.domain.com:21323/");

	private String url;

	Environment(String envUrl) {
		this.url = envUrl;
	}

	public String getUrl() {
		return url;
	}
	
}
