package com.amirserry.postfix_evaluation;

public class EvaluateExpersion {

	private String[] items;
	
	private Stack stack= new Stack();
	
	private Stack opStack= new Stack();
	
	
	public double Evaluate(String equation) {
		return EvaluateFromPostfix(convertToPostFix(equation));
	}
	
	
	private double EvaluateFromPostfix(String postfix) {
		items= postfix.split(" ");
		double result=0;
		for(String item:items) {
			
			if(isNumeric(item)) {
				stack.push(item);
			}
			else {
				double firstItem = Double.parseDouble(stack.pop());
				double secondItem =  Double.parseDouble(stack.pop());
				
				result = calaucate (secondItem,firstItem,item);
				stack.push(result+"");

			}
		}
		
		
		return result;
	}
	
	private String convertToPostFix(String infix) {
		String[] items= infix.split(" ");
		String infixString="";
		for(String item:items) {
			if(isNumeric(item)) {
				infixString=infixString + " " + item;
			}
			else {
				if(opStack.isEmpty()) {
					opStack.push(item);
				}
				else {
					String op1 = opStack.pop();
					String op2 = item;
					Integer opResult=checkPriorization(op1,op2);
					if(opResult==1)
					{
						opStack.push(op1);
						opStack.push(op2);
					}
					else {
						infixString=infixString + " " + op1;
						while(!opStack.isEmpty()) {
							infixString=infixString + " " + opStack.pop();
						}
						opStack.push(op2);
						
						
					}
					
				}
				
			}
			
		}
		while(!opStack.isEmpty()) {
			infixString=infixString + " " + opStack.pop();
		}

		System.out.println("PostFix is:" + infixString);
		return infixString;
	}
	
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
