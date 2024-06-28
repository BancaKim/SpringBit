package com.kbfg.digi;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return Student.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		System.out.println("validate()");
		Student student = (Student)obj;
		
//      1번째 방법
//		String studentName = student.getName();
//		if(studentName == null || studentName.trim().isEmpty()) {
//			System.out.println("studentName is null or empty");
//			errors.rejectValue("name","trouble");
//		}
//      2번째 방법	
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","trouble");  //에러, 필드, 에러코드, 디폴트 에러메세지
		
		int studentId = student.getId();
		if(studentId == 0) {
			System.out.println("studentId is 0");
			errors.rejectValue("id","trouble");
		}
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id","trouble");  //에러, 필드, 에러코드, 디폴트 에러메세지
		
	}

}
