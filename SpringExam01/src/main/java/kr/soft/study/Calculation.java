package kr.soft.study;

public class Calculation {
	private int firstNum;
	private int secondNum;
	
	
	
	public void setFirstNum(int num) {
		firstNum = num;
	}
	
	public void setSecondNum(int num) {
		secondNum = num;
	}
	
	public void addition() {
		int result = firstNum + secondNum;
		System.out.println("addition()");
		System.out.println(firstNum+" + "+secondNum+" = "+result);
	}
	
	public void subtraction() {
		int result = firstNum - secondNum;
		System.out.println("subtraction()");
		System.out.println(firstNum+" - "+secondNum+" = "+result);
	}
	
	public void multiplication() {
		int result = firstNum * secondNum;
		System.out.println("multiplication()");
		System.out.println(firstNum+" * "+secondNum+" = "+result);
	}
	
	public void division() {
		int result = firstNum / secondNum;
		System.out.println("division()");
		System.out.println(firstNum+" / "+secondNum+" = "+result);
	} 
	
}
