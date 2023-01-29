package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class Fortune {

	public void getFortune() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---- FORTUNE-----");
	}
}
