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
	
//	@Pointcut("execution(public void get*(..))") //public void�� ��� get�޼ҵ�
//	@Pointcut("execution(* com.kbfg.digi..*(..))") //com.kbfg.digi ��Ű���� �Ķ���Ͱ� ���� ��� �޼���
//	@Pointcut("execution(* com.kbfg.digi..*.*(..))") //com.kbfg.digi ��Ű�� & ���� ��Ű���� �Ķ���Ͱ� ���� ��� �޼ҵ�
	@Pointcut("execution(* com.kbfg.digi.Worker.*(..))") //com.kbfg.digi.Worker���� ��� �޼ҵ�
	
//	@Pointcut("within(com.kbfg.digi.*)") //kr.soft.study. ��Ű�� �ȿ� �ִ� ��� �޼���
//	@Pointcut("within(com.kbfg.digi..*)") //kr.soft.study. ��Ű�� �� ���� ��Ű�� ���� ��� �޼���
//	@Pointcut("within(com.kbfg.digi.Worker)") //kr.soft.study.Worker ���� ��� �޼���
	
//	@Pointcut("bean(student)") //bean - Ư�� �� �����ϰڴ�
//	@Pointcut("bean(*ker)") //~ker�� ������ �󿡸� ����
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
			System.out.println( signatureStr + " ����ð� : " + (et - st));
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