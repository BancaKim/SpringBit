package com.kbfg.digi;

public class StudentInfo {
	private Student student;
	
	public StudentInfo() {
		
	}
	public StudentInfo(Student student) {
		this.student = student;    //��ü ����
	}
	
	public void getStudentInfo() {
		if(student != null) {
			System.out.println("�̸� : "+student.getName());
			System.out.println("���� : "+student.getHobbys());
			System.out.println("=======================");
		}
	}

	public void setStudent(Student student) {
		this.student = student;  //��ü ����
	}
	
	public Student getStudent() {
		return student;
	}
	
}
