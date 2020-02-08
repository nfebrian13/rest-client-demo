package com.ogp.nana;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONObject;

import com.ogp.nana.constant.Environment;
import com.ogp.nana.model.Token;
import com.ogp.nana.util.ConsumeApi;

public class MainClass {

	public static void main(String[] args) throws ClientProtocolException, IOException {
		Token token = processToken();
		System.out.println(token.getAccess_token());
		System.out.println(token.getToken_type());
		System.out.println(token.getExpires_in());
		System.out.println(token.getScope());
	}

	public static Token processToken() {
		Token token = new Token();
		ConsumeApi api = new ConsumeApi();
		Map<String, String> map = new HashMap<String, String>();

		try {
			map = api.getTokenWithResponse(Environment.BNI.getUrl());
			if (map.get("statusCode") != null && map.get("statusCode").equals("200")) {
				JSONObject resultToken = new JSONObject(map.get("result"));
				token.setAccess_token(resultToken.get("access_token").toString());
				token.setToken_type(resultToken.get("token_type").toString());
				token.setExpires_in(resultToken.get("expires_in").toString());
				token.setScope(resultToken.get("scope").toString());
				
			} else {
				System.out.println("server error");

			}
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return token;
	}

}
