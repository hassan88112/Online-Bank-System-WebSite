package com.hassan.OnlineBanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineBankingApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(OnlineBankingApplication.class, args);
		} catch (Exception e) {
			System.out.println("test hassan " + e);
		}
	}
}
