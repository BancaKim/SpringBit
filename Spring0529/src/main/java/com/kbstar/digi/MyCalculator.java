package com.kbstar.digi;

public class MyCalculator {
	private int firstNum;
	private int secondNum;
	private Calculator calculator;
	
	public int getFirstNum() {
		return firstNum;
	}

	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}

	public int getSecondNum() {
		return secondNum;
	}

	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	/*
	 * 
	 * public MyCalculator(){
	 * 	calculator = new Calculator()
	 * }
	 */

	public void setCalculator(Calculator calculator) { //객체를 주입한다
		this.calculator = calculator;
	}
	
	public void add() {
		calculator.addition(firstNum, secondNum);
	}
	
	public void sub() {
		calculator.subtraction(firstNum, secondNum);
	}
	
	public void mul() {
		calculator.multiplication(firstNum, secondNum);
	}
	
	public void div() {
		calculator.division(firstNum, secondNum);
	}
}
