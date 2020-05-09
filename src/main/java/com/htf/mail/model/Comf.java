package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Comf implements Serializable{
	private static final long serialVersionUID = 4336999113318397282L;
	
	private String brf;//生活指数简介
	private String txt;//数据详情

}

