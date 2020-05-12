package com.htf.mail;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class WeatherForecast {
	
	@Value("${city}")
	private String city;
	
	CloseableHttpClient httpClient;

	private CloseableHttpClient getHttpClient() {
		if (httpClient == null) {
			httpClient = HttpClientBuilder.create().build();
		}
		return httpClient;
	}
	
	@SuppressWarnings("unchecked")
	public String sendWeatherForecast() {
		String returnString = "";
		final HttpGet get = new HttpGet("https://way.jd.com/he/freeweather?city="+"beijing"+"&appkey=8d76c9965eb4848bd99ba6e8e227c182");
		
		try (CloseableHttpResponse response = getHttpClient().execute(get)){
			if (response.getStatusLine().getStatusCode() == 200) {
	            String str = EntityUtils.toString(response.getEntity());
	            U2Response u2Response = JSONObject.parseObject(str, U2Response.class);
	            if(u2Response != null && u2Response.code.equals("10000") && u2Response.result != null) {
	            	Map<String,Object> map = JSONObject.parseObject(u2Response.result,Map.class);
	            	returnString = map.get("HeWeather5").toString();
	            }
	        }
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnString;
	}
	
	public static void main(String[] args) {
		WeatherForecast wf = new WeatherForecast();
		wf.sendWeatherForecast();
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
class U2Response{
	public String code;
	public String msg;
	public String result;
}

