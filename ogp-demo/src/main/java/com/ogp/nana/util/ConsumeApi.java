package com.ogp.nana.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class ConsumeApi {

	public String getToken(String urlToRead) throws ClientProtocolException, IOException {
		String result = "";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		String auth = "MTg2NzAzY2EtMTQxYS00OTZiLWI0M2MtMzk2NDY1Zjk5MzI0OmVkMTRiZjJlLWU2YmEtNGZmYi04OWY2LTYxMjQzOTJiODA0NQ==";

		try {
			HttpPost postRequest = new HttpPost(urlToRead);
			postRequest.setHeader("Authorization", "Basic " + auth);
			postRequest.setHeader("content-type", "application/x-www-form-urlencoded");

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("grant_type", "client_credentials"));

			postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			result = httpClient.execute(postRequest, responseHandler);

		} finally {
			httpClient.close();
		}

		return result;
	}

	public Map<String, String> getTokenWithResponse(String urlToRead) throws ClientProtocolException, IOException {

		String result = "";

		Map<String, String> map = new HashMap<String, String>();
		ResponseHandler<String> handler = new BasicResponseHandler();

		CloseableHttpClient httpClient = HttpClients.createDefault();
		String auth = "MTg2NzAzY2EtMTQxYS00OTZiLWI0M2MtMzk2NDY1Zjk5MzI0OmVkMTRiZjJlLWU2YmEtNGZmYi04OWY2LTYxMjQzOTJiODA0NQ==";

		try {
			HttpPost postRequest = new HttpPost(urlToRead);
			postRequest.setHeader("Authorization", "Basic " + auth);
			postRequest.setHeader("content-type", "application/x-www-form-urlencoded");

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
			nameValuePairs.add(new BasicNameValuePair("grant_type", "client_credentials"));

			postRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			HttpResponse response = httpClient.execute(postRequest);

			result = handler.handleResponse(response);
			Integer statusCode = response.getStatusLine().getStatusCode();
			
			map.put("result", result);
			map.put("statusCode", statusCode.toString());

		} finally {
			httpClient.close();
		}

		return map;
	}

}
