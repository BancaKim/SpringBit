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
		
		Student student = new Student("ȫ�浿",20,hobbys);
		student.setHeight(180);
		student.setHeight(80);
		
		return student;
	}
	
//	@Bean  //�޼ҵ� �������� ����
//	public Student student2() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
//		
//		ArrayList<String> hobbys = new ArrayList<String>();
//		hobbys.add("����");
//		hobbys.add("�ڵ�");
//		
//		Student student = new Student("ȫ����",20,hobbys);
//		student.setHeight(150);
//		student.setHeight(90);
//		
//		return student;
//	}
	
}
