package com.ogp.nana.util;

import org.json.JSONException;
import org.json.JSONObject;

import com.ogp.nana.model.Token;

public class TokenConverter {

	public Token tokenConverter(JSONObject tokenObj) throws JSONException {
		Token token = new Token();
		token.setAccess_token(tokenObj.isNull("access_token") ? null : tokenObj.get("access_token").toString());
		token.setToken_type(tokenObj.isNull("Bearer") ? null : tokenObj.get("Bearer").toString());
		token.setExpires_in(tokenObj.isNull("expires_in") ? null : tokenObj.get("expires_in").toString());
		token.setScope(tokenObj.isNull("scope") ? null : tokenObj.get("scope").toString());
		return token;
	}
	
}
