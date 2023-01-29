package com.luv2code.aopdemo.dao;

public class Account {

	String name;
	int money;
	
	public Account(String name, int money) {
		this.name = name;
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", money=" + money + "]";
	}
}
