package com.amirserry.postfix_evaluation;

public class EvaluateExpersion {

	
private double calaucate(double firstItem,double secondItem,String operante) {
		
		if(operante.equals("*"))
		{
			return firstItem * secondItem;
		}
		else if(operante.equals("/"))
		{
			return firstItem / secondItem;
		}
		else if(operante.equals("+"))
		{
			return firstItem + secondItem;
		}
		else if(operante.equals("-"))
		{
			return firstItem - secondItem;
		}
		return 0;
	}
	
	private boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(strNum);
	       
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	private Integer checkPriorization(String op1,String op2) {
		
		if(isHiger(op1,op2)) {
			return 1;
		}else {
			return 0;
		}
		
	}
	
	private Boolean isHiger(String op1,String op2) {
		
		int op1Number=getOperationNumber(op1);
		int op2Number=getOperationNumber(op2);		
		
		if(op1Number < op2Number){
			return true;
		}
		else {
			return false;
		}
		
	}
	
	private int getOperationNumber(String op) {
		switch (op){
		case "+": return 1;
		case "-": return 1;
		case "*": return 2;
		case "/": return 2;
		default: return 0;
		}
	}
}
