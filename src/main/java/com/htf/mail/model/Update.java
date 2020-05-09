package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Update  implements Serializable{
	private static final long serialVersionUID = 8721019634547534153L;
	private String loc;//当前时间
	private String utc;//天气更新时间
	
}

