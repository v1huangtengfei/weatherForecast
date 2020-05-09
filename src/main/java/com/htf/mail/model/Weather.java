package com.htf.mail.model;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Weather implements Serializable{

	private static final long serialVersionUID = -753800314574993475L;
	private Aqi aqi;//AQI
	private Basic basic;//城市信息
	private List<Daily> daily_forecast;//7日天气预报
	private List<Hourly> hourly_forecast;//小时天气预报
	private Hourly now;//实况天气
	private String status;//返回状态
	private String suggestion;//生活指数
}

