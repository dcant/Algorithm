package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s.length() <= nRows || nRows == 1)
            return s;
        LinkedList<Character>[] ls = new LinkedList[nRows];
        char[] arr = new char[s.length()];
        for (int i = 0; i < nRows; i++) {
        	LinkedList<Character> tmp = new LinkedList<Character>();
        	ls[i] = tmp;
        }
        boolean flag = false;
        int k = 0;
        int r1 = nRows - 1;
        int fac = 2 * nRows - 2;
        for (int i = 0; i < s.length(); i++) {
        	ls[k].addLast(s.charAt(i));
        	if ((i-r1) % fac == 0)
        		flag = true;
        	if (i % fac == 0)
        		flag = false;
        	if (flag)
        		k--;
        	else
        		k++;
        }
        k = 0;
        for (int i = 0; i < nRows; i++) {
        	while (!ls[i].isEmpty()) {
        		arr[k++] = ls[i].pop();
        	}
        }
        return new String(arr);
    }
}
