package com.kbfg.digi;

import javax.inject.Inject;
import javax.inject.Named;

public class ContactRegisterService {
	@Inject
	@Named("contactDao1")
	private ContactDao contactDao;  //필드에 resource 적용
	
//	public ContactRegisterService() {
//		System.out.println("default constructor");
//	};
	
	@Inject
	@Named("contactDao1")
	public ContactRegisterService(ContactDao contactDao) {  
		System.out.println("contactDao:" + contactDao);
		this.contactDao = contactDao;
	}
	
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

	@Inject
	@Named("contactDao1")
	public void setWordDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
	
}
