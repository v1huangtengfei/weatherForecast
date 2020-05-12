package com.htf.mail;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.htf.mail.model.Weather;

@RestController
@RequestMapping("/weather")
public class Controller {
	
	@Value("${receiverList}")
	private String receiverList;
	
	@RequestMapping(value = "/sendWeather",method = RequestMethod.GET)
	public String sendWeather() {
		WeatherForecast wf = new WeatherForecast();
		String string = wf.sendWeatherForecast();
		if(string != null && !string.equals("")) {
			List<Weather> list = JSONObject.parseArray(string, Weather.class);
			Weather weather = list.get(0);
			MailUtil.send(weather.getBasic().getCity()+"天气预报", weather.toString(), receiverList);
			return "发送成功！";
		}else {
			return "因不明原因未查出天气!!!";
		}
	}
}

