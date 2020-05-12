package com.htf.mail;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.htf.mail.model.Weather;

@Component
@Lazy(false)
public class Timer {
	
	@Value("${receiverList}")
	private String receiverList;
	
	@Scheduled(cron = "0 0 8 * * ?")
	public void sendMail() {
		WeatherForecast wf = new WeatherForecast();
		String string = wf.sendWeatherForecast();
		if(string != null && !string.equals("")) {
			List<Weather> list = JSONObject.parseArray(string, Weather.class);
			Weather weather = list.get(0);
			MailUtil.send(weather.getBasic().getCity()+"天气预报", weather.toString(), receiverList);
			System.out.println("发送成功！");
		}else {
			System.out.println("因不明原因未查出天气!!!");
		}
	}
}

