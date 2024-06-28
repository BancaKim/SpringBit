package com.kbstar.digi;

public class Calculator {

	public void addition(int firstNum, int secondNum) {
		int result = firstNum + secondNum;
		System.out.println("addition()");
		System.out.println(firstNum+" + "+secondNum+" = "+result);
	}
	
	public void subtraction(int firstNum, int secondNum) {
		int result = firstNum - secondNum;
		System.out.println("subtraction()");
		System.out.println(firstNum+" - "+secondNum+" = "+result);
	}
	
	public void multiplication(int firstNum, int secondNum) {
		int result = firstNum * secondNum;
		System.out.println("multiplication()");
		System.out.println(firstNum+" * "+secondNum+" = "+result);
	}
	
	public void division(int firstNum, int secondNum) {
		int result = firstNum / secondNum;
		System.out.println("division()");
		System.out.println(firstNum+" / "+secondNum+" = "+result);
	} 
	
}
