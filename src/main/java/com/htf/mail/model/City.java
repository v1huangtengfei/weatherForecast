package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class City  implements Serializable{
	private static final long serialVersionUID = 2507229697698503041L;
	private String aqi; //AQI
	private String qlty; //空气质量
	private String pm25; //PM2.5
	private String pm10; //PM10
	private String no2;  //NO2
	private String so2;  //SO2
	private String co;   //CO
	private String o3;   //O3
	
}

