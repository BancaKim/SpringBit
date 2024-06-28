package com.kbfg.digi;

import org.springframework.beans.factory.annotation.Autowired;

public class ContactRegisterService {
	@Autowired
	private ContactDao contactDao;  //필드에 Autowired 적용
	
//	public ContactRegisterService() {
//		System.out.println("default constructor");
//	};
	
//	@Autowired
//	public ContactRegisterService(ContactDao contactDao) {  //생성자에 Autowired 적용
//		System.out.println("contactDao:" + contactDao);
//		this.contactDao = contactDao;
//	}
	
	public void register(ContactSet contactSet) {
		String name = contactSet.getName();
		if(verify(name)) {
			contactDao.insert(contactSet);
		} else {
			System.out.println("The name has already registered.");
		}
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet == null ? true : false; 
	}
	
	@Autowired
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
