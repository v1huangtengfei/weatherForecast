package com.htf.mail.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Aqi implements Serializable{
	
	private static final long serialVersionUID = -1662575001928183551L;
	
	private City city;

}

