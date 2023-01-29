package com.luv2code.aopdemo;

import java.util.Iterator;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.Fortune;
import com.luv2code.aopdemo.dao.MembershipDemo;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		//call the business method
		accountDAO.addAccount();
		accountDAO.getAccount();
		accountDAO.setAccount();
		
		accountDAO.getAccountList();

		try {
			accountDAO.throwError(true);
		}catch(Exception exception) {
			System.out.println("In MainDemoApp .. got the error: "+ exception.getMessage());
		}
		
		accountDAO.throwError(false);
		
		MembershipDemo membershipDemo = context.getBean(MembershipDemo.class);
		membershipDemo.addAccount();
		
		membershipDemo.addSillyMemberShip();
		
		Fortune fortuneBean = context.getBean(Fortune.class);
		fortuneBean.getFortune();
		//close the context
		context.close();
	}
}
