package com.kbfg.digi;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(); //����
		
		ctx.load("classpath:applicationCTX.xml"); //����
		
		ctx.refresh();  // ������ �Ű������� ���� �ʾ����� �̷��� ���� ������ �ۼ���     -> afterPropertiesSet() ȣ�� �ּ��ϸ� �ȳ��� destroy��
		
//		OtherStudent student = ctx.getBean("student",OtherStudent.class); //���
//		System.out.println("�̸� : "+student.getName());
//		System.out.println("���� : "+student.getAge());
		
		ctx.close(); // ���� ���� �Ҹ�
//		System.out.println("�̸� : "+student.getName());
//		System.out.println("���� : "+student.getAge());
//		
//		ctx.close(); // ����
//		System.out.println("�̸� : "+student.getName());
//		System.out.println("���� : "+student.getAge());
		
	}
}
