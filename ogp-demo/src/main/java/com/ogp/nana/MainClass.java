package com.ogp.nana;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.ogp.nana.util.ConsumeApi;

public class MainClass {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		String urlToRead = "https://apidev.bni.co.id:8067/api/oauth/token";
		ConsumeApi api = new ConsumeApi();
		api.getToken(urlToRead);
	}
}
