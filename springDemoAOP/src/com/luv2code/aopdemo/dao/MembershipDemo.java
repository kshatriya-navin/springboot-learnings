package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDemo {

	public void addAccount() {
		System.out.println(getClass()+ " Doing STUFF. Adding membership ACCOUNT!");
	}
	
	public boolean addSillyMemberShip() {
		System.out.println(getClass()+ " Silly STUFF. Adding membership ACCOUNT!");
		return true;
	}
}
