package com.kbfg.digi;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //������ ���� ���Ϸ� �ν��ϰڴٶ�� �� application.xml ��� beans ����
public class ApplicationConfig {
	
	@Bean  //�޼ҵ� �������� ����
	public Student student3() {  //ctx.getBean("student1", Student.class); ��ȯŸ�� = Student.class 
		
		ArrayList<String> hobbys = new ArrayList<String>();
		hobbys.add("����");
		hobbys.add("�ڵ�");
		
		Student student = new Student("ȫ����",hobbys);
		
		return student;
	}
	
	@Bean
	public Family family() {
		Family family = new Family("ȫ�ƺ�","ȫ����");
		family.setSisterName("ȫ����");
		family.setBrotherName("ȫ����");
		
		return family;
	}
	
}
