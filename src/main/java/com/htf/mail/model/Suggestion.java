package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Suggestion implements Serializable{
	private static final long serialVersionUID = -5197965692185325272L;
	private Comf air;	//外出指数
	private Comf comf;	//舒适度指数
	private Comf cw;	//洗车指数
	private Comf drsg;	//穿衣指数
	private Comf flu;	//感冒指数
	private Comf sport;	//运动指数
	private Comf trav;	//旅游指数
	private Comf uv;	//紫外线指数
}

