package com.kbfg.digi;

import javax.inject.Inject;
import javax.inject.Named;

public class ContactSearchService {
	@Inject
	@Named("contactDao1")
	private ContactDao contactDao;
	
//	public ContactSearchService() {
//		System.out.println("default constructor");
//	};
	
	@Inject
	@Named("contactDao1")
	public ContactSearchService(ContactDao contactDao) {
		System.out.println("contactDao:"+contactDao);
		this.contactDao = contactDao;
	}
	
	public ContactSet searchContact(String name) {
		if(verify(name)) {
			return contactDao.select(name);
		} else {
			System.out.println("Contact information is available");
		}
		return null;
	}
	
	public boolean verify(String name) {
		ContactSet contactSet = contactDao.select(name);
		return contactSet != null? true:false;
	}
	
	@Inject
	@Named("contactDao1")
	public void setContactDao(ContactDao contactDao) {
		this.contactDao = contactDao;
	}
}
