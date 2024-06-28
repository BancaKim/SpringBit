package com.kbfg.digi;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //생성
		
		ctx.load("classpath:applicationCTX.xml"); //설정
		
		ctx.refresh();  // 생성자 매개변수에 넣지 않았을때 이렇게 두줄 나눠서 작성함     -> afterPropertiesSet() 호출 주석하면 안나옴 destroy도
		
//		OtherStudent student = ctx.getBean("student",OtherStudent.class); //사용
//		System.out.println("이름 : "+student.getName());
//		System.out.println("나이 : "+student.getAge());
		
		ctx.close(); // 종료 빈즈 소멸
//		System.out.println("이름 : "+student.getName());
//		System.out.println("나이 : "+student.getAge());
//		
//		ctx.close(); // 종료
//		System.out.println("이름 : "+student.getName());
//		System.out.println("나이 : "+student.getAge());
		
	}
}
