package com.htf.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherForecastApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(WeatherForecastApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
