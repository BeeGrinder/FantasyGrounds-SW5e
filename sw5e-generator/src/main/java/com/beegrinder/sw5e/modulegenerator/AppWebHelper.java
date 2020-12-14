package com.beegrinder.sw5e.modulegenerator;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;


public class AppWebHelper {

	public static String getRestData(String urlString) {
		String retVal = new String();
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
			if( StringUtils.isNotBlank( responseString ) ) retVal = responseString;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return retVal;
	}

}

