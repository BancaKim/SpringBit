package com.kbfg.digi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //������ ���� ���Ϸ� �ν��ϰڴٶ�� �� application.xml ��� beans ����
public class ApplicationConfig {

	@Bean  //�޼ҵ� �������� ����
	public Student student1() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
		
		Student student = new Student();
		student.setName("ȫ�浿");
		student.setAge("10��");
		student.setGradeNum("3�г�");
		student.setClassNum("20��");
		
		return student;
	}
	
	@Bean  //�޼ҵ� �������� ����
	public Student student2() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
		
		Student student = new Student("ȫ����","20��", "2�г�","7��");
		
		return student;
	}
	@Bean
	public StudentInfo studentInfo() {
		StudentInfo studentInfo = new StudentInfo(student1());
		return studentInfo;
	}
}
