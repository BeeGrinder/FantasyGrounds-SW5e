package com.beegrinder.sw5e.modulegenerator;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppRestHelper {

	public static JsonNode getRestData(String urlString) {
		JsonNode retVal = JsonNodeFactory.instance.objectNode();
		try {
			OkHttpClient client = new OkHttpClient();
			Request request = new Request.Builder().url(urlString).build();
			Response responses = null;

			try {
				responses = client.newCall(request).execute();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String responseString = responses.body().string();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode dataNode = mapper.readTree(responseString);
			if( dataNode.isArray() ) {
				retVal = dataNode;
				int ct=dataNode.size();
				System.out.println(ct);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}

}
