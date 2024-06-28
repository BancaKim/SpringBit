package com.kbfg.digi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //스프링 설정 파일로 인식하겠다라는 뜻 application.xml 상단 beans 동일
public class ApplicationConfig {

	@Bean  //메소드 형식으로 만듬
	public Student student1() {  //ctx.getBean("student1", Student.class); 반환타입 = Student.class 
		
		Student student = new Student();
		student.setName("홍길동");
		student.setAge("10살");
		student.setGradeNum("3학년");
		student.setClassNum("20번");
		
		return student;
	}
	
	@Bean  //메소드 형식으로 만듬
	public Student student2() {  //ctx.getBean("student1", Student.class); 반환타입 = Student.class 
		
		Student student = new Student("홍길자","20살", "2학년","7번");
		
		return student;
	}
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(student1());
		return studentInfo;
	}
}
