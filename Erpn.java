package cn.edu.sjtu.zzang;

import java.util.Stack;

/* Evaluate reverse polish notation 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class Erpn {
	public static void main(String[] args) {
		String[] notations = {"2", "3", "+", "4", "*"};
		Erpn erpn = new Erpn();
		int result = erpn.erpnhelper(notations);
		System.out.println(result);
	}
	
	public int erpnhelper(String[] notation) {
		String ops = "+-*/";
		Stack<String> stack = new Stack<String>();
		
		for (String s : notation) {
			if (!ops.contains(s))
				stack.push(s);
			else {
				int index = ops.indexOf(s);
				int x = Integer.valueOf(stack.pop());
				int y = Integer.valueOf(stack.pop());
				switch (index) {
				case 0:
					stack.push(String.valueOf(x + y));
					break;
				case 1:
					stack.push(String.valueOf(x - y));
					break;
				case 2:
					stack.push(String.valueOf(x * y));
					break;
				case 3:
					stack.push(String.valueOf(x / y));
					break;
				}
			}
		}
		return Integer.valueOf(stack.pop());
	}
}
