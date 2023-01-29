package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-5)
public class MyDemoLoggingAspect {

	//This is where we add all of our related advice for logging
	
	//Before advice
	
	//Pointcut expression to call addAccount method present in any class
	// @Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())") to only match that class method 
	// (fully qualified class name should be given)
	//@Before("execution(public void add*())") //to match with any method starting with add in any class with void and public
//	@Before("execution(* add*())") //to match with any method starting with add in any class with void and public
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	private void forDAOPackage() {
	}
	
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDAOPackage() && !(getter() || setter())") //combine pointcuts
	private void forDAOPackageNotGetterSetter() {}
	
	
	@Before("forDAOPackageNotGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n=======> Executing Before advice on addAccount()");

		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();
		System.out.println("Method: " + methodSign);
		
		Object[] args = joinPoint.getArgs();
		for(Object tempArgs : args) {
			System.out.println(tempArgs);
		}
		
	}
	
	// @Before("forDAOPackage()") - Pointcuts can be used multiple time
	public void beforeSample() {
		System.out.println("\n=======> Executing Before advice on addAccount()");
	}
	
}
