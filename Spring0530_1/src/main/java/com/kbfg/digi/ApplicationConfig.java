package com.kbfg.digi;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //������ ���� ���Ϸ� �ν��ϰڴٶ�� �� application.xml ��� beans ����
public class ApplicationConfig {

	@Bean  //�޼ҵ� �������� ����
	public Student student1() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�丮");
		
		Student student = new Student("ȫ�浿",hobbys);

		return student;
	}
	
	@Bean  //�޼ҵ� �������� ����
	public Student student3() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�ڵ�");
		
		Student student = new Student("ȫ����",hobbys);
		
		return student;
	}
	@Bean
	public StudentInfo studentInfo1() {
		StudentInfo studentInfo = new StudentInfo(student1());
		return studentInfo;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("ȫ�ƺ�","ȫ����");
		family.setSisterName("ȫ����");
		family.setBrotherName("ȫ����");
		
		return family;
	}
	
}
