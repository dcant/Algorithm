package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses lvp = new LongestValidParentheses();
		System.out.println(lvp.longestValidParentheses("(())(((())))(()"));
	}
	
    public int longestValidParentheses(String s) {
    	if (s.length() == 0)
    		return 0;
    	int res = 0;
        LinkedList<Integer> sub = new LinkedList<Integer>();
        LinkedList<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	switch(c) {
        	case '(':
        		stack.push(c);
        		sub.push(i);
        		break;
        	case ')':
        		if (!stack.isEmpty()) {
	        		if(stack.peek() == '(') {
	        			stack.pop();
	        			sub.pop();
	        		} else {
	        			stack.push(c);
	        			sub.push(i);
	        		}
        		} else {
        			stack.push(c);
        			sub.push(i);
        		}
        	}
        }
        int lo = -1;
        while (!sub.isEmpty()) {
        	int hi = sub.pollLast();
        	if (res < hi - lo - 1)
        		res = hi - lo -1;
        	lo = hi;
        }
        if (lo != s.length())
        	if (res < s.length() - lo - 1)
        		res = s.length() - lo - 1;
        return res;
    }
}
