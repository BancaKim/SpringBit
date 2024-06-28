package com.kbfg.digi;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
//	@Pointcut("execution(public void get*(..))") //public void인 모든 get메소드
//	@Pointcut("execution(* com.kbfg.digi..*(..))") //com.kbfg.digi 패키지에 파라미터가 없는 모든 메서드
//	@Pointcut("execution(* com.kbfg.digi..*.*(..))") //com.kbfg.digi 패키지 & 하위 패키지에 파라미터가 없는 모든 메소드
	@Pointcut("execution(* com.kbfg.digi.Worker.*(..))") //com.kbfg.digi.Worker안의 모든 메소드
	
//	@Pointcut("within(com.kbfg.digi.*)") //kr.soft.study. 패키지 안에 있는 모든 메서드
//	@Pointcut("within(com.kbfg.digi..*)") //kr.soft.study. 패키지 및 하위 패키지 안의 모든 메서드
//	@Pointcut("within(com.kbfg.digi.Worker)") //kr.soft.study.Worker 안의 모든 메서드
	
//	@Pointcut("bean(student)") //bean - 특정 빈에 적용하겠다
//	@Pointcut("bean(*ker)") //~ker로 끝나는 빈에만 적용
	private void pointcutMethod() {}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String signatureStr = joinpoint.getSignature().toShortString();
		System.out.println(signatureStr + " is start.");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		} finally {
			long et = System.currentTimeMillis();
			System.out.println( signatureStr + " is finished.");
			System.out.println( signatureStr + " 경과시간 : " + (et - st));
		}		
	}
	
	@Before("within(com.kbfg.digi.*)")
	public void beforAdvice() {
		System.out.println("beforAdvice()");
	}
	
	@AfterReturning("within(com.kbfg.digi.*)")
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice");
	}
	
	@AfterThrowing("within(com.kbfg.digi.*)")
	public void afterThrowingAdvice() {
		System.out.println("afterThrowingAdvice()");
	}
	
	@After("within(com.kbfg.digi.*)")
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
	
}