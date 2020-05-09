package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Astro  implements Serializable{
	private static final long serialVersionUID = 118045465554088013L;
	private String mr;//月升时间
	private String ms;//月落时间
	private String sr;//日出时间
	private String ss;//日落时间
	
}

