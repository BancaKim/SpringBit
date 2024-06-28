package com.kbfg.digi;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
public static void main(String[] args) {
	
	//IoC �����̳� ����
	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");
	
	//���� ������
	InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
	String[] names = initSampleData.getNames();
	String[] phoneNumbers = initSampleData.getPhoneNumbers();
	
	//������ ���
	ContactRegisterService registerService = ctx.getBean("registerService", ContactRegisterService.class);
	for (int i=0; i<names.length;i++) {
		ContactSet contactSet = new ContactSet(names[i],phoneNumbers[i]);
		registerService.register(contactSet);
	}
	
	//������ ��ȸ
	ContactSearchService searchService = ctx.getBean("searchService",ContactSearchService.class);
	
	ContactSet contactSet = searchService.searchContact("������");
	System.out.println("name:"+contactSet.getName());
	System.out.println("phone number:"+contactSet.getPhoneNumber());
	System.out.println("=====================");
	
	contactSet = searchService.searchContact("�����");
	System.out.println("name:"+contactSet.getName());
	System.out.println("phone number:"+contactSet.getPhoneNumber());
	System.out.println("=====================");
	
	contactSet = searchService.searchContact("�迬��");
	System.out.println("name:"+contactSet.getName());
	System.out.println("phone number:"+contactSet.getPhoneNumber());
	System.out.println("=====================");
	
	ctx.close();
}
}