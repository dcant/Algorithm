package cn.edu.sjtu.zzang;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
	public static void main(String[] args) {
		GenerateParentheses gp = new GenerateParentheses();
		LinkedList<String> l = gp.generateParenthesis(3);
		while (!l.isEmpty()) {
			String s = l.pop();
			System.out.println(s);
		}
	}
    public LinkedList<String> generateParenthesis(int n) {
        if (n == 0)
        	return null;
        LinkedList<String> list = new LinkedList<String>();
        helper(n, 0, 0, "", list);
        return list;
        	
    }
    private void helper(int n, int left, int right, String s, List<String> list) {
    	if (left < right)
    		return;
    	if (left == n && right == n) {
    		list.add(s);
    		return;
    	}
    	if (left == n) {
    		helper(n, left, right + 1, s + ")", list);
    		return;
    	}
    	helper(n, left + 1, right, s + "(", list);
    	helper(n, left, right + 1, s + ")", list);
    }
}
