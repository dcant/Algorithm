package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class SimplifyPath {
	public static void main(String[] args) {
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath("/..."));
	}

    public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        if (path == null)
        	return null;
        if (path.length() <= 1)
        	return path;
        int last = 0;
        for (int i = 0, len = path.length(); i < len; i++) {
        	if (path.charAt(i) == '/') {
        		if (last != i) {
        			String tmp = path.substring(last + 1, i);
        			if (tmp.equals("..")) {
        				if (!stack.isEmpty())
        					stack.pop();
        			} else if (!tmp.equals(".") && !tmp.equals(""))
        				stack.push(tmp);
        			last = i;
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        if (path.charAt(path.length() - 1) != '/') {
        	if (path.substring(last + 1).equals("..")) {
        		if (!stack.isEmpty())
        			stack.pop();
        	} else if (!path.substring(last + 1).equals("."))
        		stack.push(path.substring(last + 1));
        }
        if (stack.isEmpty())
        	sb.append('/');
        while (!stack.isEmpty()) {
        	sb.append('/');
        	sb.append(stack.getLast());
        	stack.removeLast();
        }
        return sb.toString();
    }
}
