package com.kbfg.digi;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //스프링 설정 파일로 인식하겠다라는 뜻 application.xml 상단 beans 동일
public class ApplicationConfig {
	
	@Bean  //메소드 형식으로 만듬
	public Student student3() {  //ctx.getBean("student1", Student.class); 반환타입 = Student.class 
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("게임");
		hobbys.add("코딩");
		
		Student student = new Student("홍길자",hobbys);
		
		return student;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("홍아빠","홍엄마");
		family.setSisterName("홍누나");
		family.setBrotherName("홍오빠");
		
		return family;
	}
	
}
