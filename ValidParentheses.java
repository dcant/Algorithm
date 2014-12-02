package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class ValidParentheses {
	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		boolean b = vp.isValid("[(])]{}");
		if (b)
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	public boolean isValid(String s) {
		if (s.length() == 0)
			return true;
		LinkedList<Character> stack = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char t;
			switch(c) {
			case '(':
			case '[':
			case '{':
				stack.addFirst(c);
				break;
			case ')':
				if (stack.isEmpty())
					return false;
				t = stack.pop();
				if (t != '(')
					return false;
				break;
			case ']':
				if (stack.isEmpty())
					return false;
				t = stack.pop();
				if (t != '[')
					return false;
				break;
			case '}':
				if (stack.isEmpty())
					return false;
				t = stack.pop();
				if (t != '{')
					return false;
				break;
			}
		}
		if (!stack.isEmpty())
			return false;
		return true;
	}
}
