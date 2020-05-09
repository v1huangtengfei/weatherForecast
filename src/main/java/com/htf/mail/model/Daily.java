package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Daily  implements Serializable{
	private static final long serialVersionUID = 8399602111977620613L;
	private Astro astro;//天文指数
	private Cond cond;//天气状况
	private String date;//日期
	private String hum;//相对湿度
	private String pcpn;//降水量
	private String pop;//降水概率
	private String pres;//大气压
	private Tmp tmp;//温度
	private String uv;//紫外线指数
	private String vis;//能见度
	private Wind wind;//风力情况
	
}

