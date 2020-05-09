package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Basic  implements Serializable{
	private static final long serialVersionUID = -7476283766361347579L;
	private String city;//城市名
	private String cnty;//国家
	private String id;//城市ID
	private String lat;//纬度
	private String lon;//经度
	private Update update;//更新时间
	
}

