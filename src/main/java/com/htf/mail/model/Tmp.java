package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tmp  implements Serializable{
	private static final long serialVersionUID = 3262146372451185447L;
	private String max;//最高温度
	private String min;//最低温度
}

