package com.kbstar.digi;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
//		ArrayList list = new ArrayList();
//		list.add("soccer");
//		
//		MyInfo myinfo = new MyInfo();
//		myinfo.setName("±è°Ç");
//		myinfo.setWeight(30);
//		myinfo.setHeight(165);
//		myinfo.setHobbys(list);
//		myinfo.setBmiCalculator(new BMICalculator());
//		java.util.ArrayList
//		myinfo.getInfo();
		
		String configLocation = "classpath:applicationCTX.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation);
		MyInfo myinfo = ctx.getBean("myInfo",MyInfo.class);
		myinfo.getInfo();
		ctx.close();
	}

}
