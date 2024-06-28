package com.kbfg.digi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		String configLocation = "classpath:applicationCTX.xml";
//		String configLocation2 = "classpath:applicationCTX1.xml";
//		AbstractApplicationContext ctx 
//		         = new GenericXmlApplicationContext(configLocation);
//		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Student student1 = ctx.getBean("student1", Student.class);
		System.out.println(student1.getName());	
		System.out.println(student1.getHobbys());	
		
		StudentInfo studentInfo = ctx.getBean("studentInfo1", StudentInfo.class);
		Student student2 = studentInfo.getStudent();	//student1  == student2 
		System.out.println(student2.getName());	
		System.out.println(student2.getHobbys());	
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2"); // student1 == student2
		}
		
		Student student3 = ctx.getBean("student3", Student.class);
		System.out.println(student3.getName());
		
		if(student1.equals(student3)) {
			System.out.println("student1 == student3");
		} else {
			System.out.println("student1 != student3");  // student1 != student3
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());  
		System.out.println(family.getMamiName());  
		System.out.println(family.getSisterName()); 
		System.out.println(family.getBrotherName()); 
		
		ctx.close();
		
	}
	
}