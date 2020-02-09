package com.ogp.nana.constant;

public enum Environment {

	BNI("https://apidev.bni.co.id:8067/api/oauth/token"), 
	SIT("https://sit.domain.com:2019/"), 
	CIT("https://cit.domain.com:8080/"),
	AUTH("MTg2NzAzY2EtMTQxYS00OTZiLWI0M2MtMzk2NDY1Zjk5MzI0OmVkMTRiZjJlLWU2YmEtNGZmYi04OWY2LTYxMjQzOTJiODA0NQ=="),
	DEV("https://dev.domain.com:21323/");

	private String url;

	Environment(String envUrl) {
		this.url = envUrl;
	}

	public String getUrl() {
		return url;
	}
	
}
