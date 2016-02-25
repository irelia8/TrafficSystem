package com.example.trafficsystem.http;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.TimeFormatException;

public class HttpRequest {
	
	public String resultStr; 
	
	public JSONObject getJsonObjByStr(String requestStr) {
		
		JSONObject obj = null;
		try {
			obj = new JSONObject(requestStr);
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
		return obj;
		
	}
	
	
	public int requestHttp(String url, String strjson){
		int status = 0;
		String info = null ;
		HttpClient client = new DefaultHttpClient(); 
		HttpPost mPost = new HttpPost(url);
		
		try {
			mPost.setEntity(new StringEntity(strjson));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
			
			System.out.println("***url:"+url);
			System.out.println("***strjson:"+strjson);
			client.getParams().setIntParameter(HttpConnectionParams.SO_TIMEOUT, 5000); // Socket超时设置5s
			client.getParams().setIntParameter(HttpConnectionParams.CONNECTION_TIMEOUT, 3000);// 连接超时3s
			HttpResponse response = client.execute(mPost);
			
			int resCode = response.getStatusLine().getStatusCode();
			if (resCode == 200) {
				HttpEntity entity = response.getEntity();
				
				if(entity != null){
					info = EntityUtils.toString(entity);
					System.out.println("***info:"+info);
					status = 1;
				}
				
			}else if (resCode == 404) {
				status = resCode;
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch bloc
			e.printStackTrace();
		} 
		
		
		return status;
		
	}
}
