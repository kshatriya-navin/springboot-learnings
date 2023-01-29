package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundJoinPointAspect {

	
	@Around("execution(* getFortune())")
	public void getAroundFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		long start = System.currentTimeMillis();
		String method = proceedingJoinPoint.getSignature().toShortString();
		System.out.println("===========> AfterReturning on method: "+ method);
		Object proceed = proceedingJoinPoint.proceed();
		
		System.out.println(getClass()+" Total time taken: "+ (System.currentTimeMillis() - start) / 1000.0);
	}
}
