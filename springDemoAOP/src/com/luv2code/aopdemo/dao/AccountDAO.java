package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass()+": Doing my DB WORK. Adding an ACCOUNT!");
	}
	
	public void getAccount() {
		System.out.println("In getter");
	}
	
	public void setAccount() {
		System.out.println("In setter");
	}
	
	public List<Account> getAccountList(){
		List<Account> accountList = new ArrayList<>(Arrays.asList(
				new Account("Navin", 5000),
				new Account("Aditya", 6000))
				);
		
		return accountList;
				
	}
	
	public void throwError(boolean b) {
		if(b)
			throw new RuntimeException("AcountDAO throwing error");
	}
}
