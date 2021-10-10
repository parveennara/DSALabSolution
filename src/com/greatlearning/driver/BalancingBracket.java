package com.greatlearning.driver;

import java.util.Stack;

public class BalancingBracket {

	static boolean checkBracket(String bracket) {

		Stack<Character> stack = new Stack<>();

		for (int i=0; i< bracket.length(); i++) {

			char c = bracket.charAt(i);

			if (c== '(' || c=='{' || c=='[') {

				stack.push(c);
				continue;				
			}

			if (stack.isEmpty()) {

				return false;
			}

			char x;

			switch(c) {

			case ')' : {				
				x = stack.pop();
				if (x=='['||x=='{')
					return false;
				break;
			}

			case ']' : {				
				x = stack.pop();
				if (x=='('||x=='{')
					return false;
				break;
			}

			case '}' : {				
				x = stack.pop();
				if (x=='('||x=='[')
					return false;
				break;
			}
			}					
		}			

		return(stack.isEmpty());
	}

	public static void main(String[] args) {

		String bracket = "([[{}]])";

		boolean result;

		result = checkBracket(bracket);

		if (result)
			System.out.println("The entered String has Balanced Brackets");
		else
			System.out.println("The entered Strings do not contain Balanced Brackets");

	}

}
