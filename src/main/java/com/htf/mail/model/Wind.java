package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Wind  implements Serializable{
	private static final long serialVersionUID = 2695475293943981541L;
	private String deg;// 风向（360度）
	private String dir;//风向
	private String sc;//风力等级
	private String spd;//风速
}

