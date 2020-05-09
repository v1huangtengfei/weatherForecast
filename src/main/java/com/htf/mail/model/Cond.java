package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Cond  implements Serializable{
	private static final long serialVersionUID = 609792428631260330L;
	private String code_d;//白天天气状况代码
	private String code_n;//夜间天气状况代码
	private String txt_d;//白天天气状况描述
	private String txt_n;//夜间天气状况描述
	
	private String code;//天气状况代码
	private String txt;//天气状况描述
	
}

