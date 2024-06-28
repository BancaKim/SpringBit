package com.kbfg.digi;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Member.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Member member = (Member)obj;
		
//      1��° ���
		String id = member.getId();
		if(id == null || id.trim().isEmpty()) {
			System.out.println("id is null or empty");
			errors.rejectValue("id","trouble");
		}
		
		String password = member.getPassword();
		if(password == null || password.trim().isEmpty()) {
			System.out.println("password is null or empty");
			errors.rejectValue("password","trouble");
		}
		
		String email = member.getEmail();
		if(email == null || email.trim().isEmpty()) {
			System.out.println("email is null or empty");
			errors.rejectValue("email","trouble");
		}
		
		String userName = member.getId();
		if(userName == null || userName.trim().isEmpty()) {
			System.out.println("userName is null or empty");
			errors.rejectValue("userName","trouble");
		}
		
//      2��° ���	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"ssn","trouble");  //����, �ʵ�, �����ڵ�, ����Ʈ �����޼���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"birthYear","trouble");  //����, �ʵ�, �����ڵ�, ����Ʈ �����޼���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"birthMonth","trouble");  //����, �ʵ�, �����ڵ�, ����Ʈ �����޼���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"birthDay","trouble");  //����, �ʵ�, �����ڵ�, ����Ʈ �����޼���
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"introduction","trouble");  //����, �ʵ�, �����ڵ�, ����Ʈ �����޼���
		
	}
		
}
