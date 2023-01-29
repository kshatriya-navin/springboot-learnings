package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(1) // This can have negative as well .. so preference is -n, -n+1, 1, n, n+1
//With same order - anyone can be picked and applied 2, 4 , 4, 6 (in both 4 anyone can be applied first and other one later) 
//but after 2 and before 6
public class SampleAspectOne {
	
	@AfterReturning(
			pointcut ="execution(* com.luv2code.aopdemo.dao.AccountDAO.getAccountList(..))",
			returning = "result"
			)
	public void afterReturingFindAccount(JoinPoint joinPoint, List<Account> result) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("===========> AfterReturning on method: "+ method);
		result.add(new Account("AOP - He he he", 9999));
		System.out.println(result.toString());
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.throwError(..))",
			throwing = "theError"
			)
	public void afterThrowing(JoinPoint joinPoint, Throwable theError) {
		String method = joinPoint.getSignature().toShortString();
		System.out.println("===========> AfterThrowing on method: "+ method);
		
		System.out.println(getClass()+" AfterThrowing The error message: "+ theError.getMessage());
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.throwError(..))")
	public void afterFinallyFinalAdvice() {
		System.out.println(getClass()+" In The AFTER pointcut");
	}
}
