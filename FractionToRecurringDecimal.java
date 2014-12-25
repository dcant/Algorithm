package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.HashMap;

public class FractionToRecurringDecimal {
	public static void main(String[] args) {
		FractionToRecurringDecimal ftr = new FractionToRecurringDecimal();
		System.out.println(ftr.fractionToDecimal(-2147483648, 1));
	}
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0)
        	return null;
        ArrayList<String> f = new ArrayList<String>();
        long num = numerator, den = denominator;
        if ((num < 0 && den > 0) || (num > 0 && den < 0))
        	f.add("-");
    	num = Math.abs(num);
    	den = Math.abs(den);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        long remain = 0;
        f.add((num/den) + "");
        remain = num % den;
        if (remain != 0) {
        	f.add(".");
        	int indx = 0;
        	while (remain != 0) {
        		remain *= 10;
        		f.add(Math.abs(remain/den) + "");
        		map.put((int)remain/10, indx);
        		remain %= den;
        		if (map.containsKey((int)remain))
        			break;
        		indx++;
        	}
        	String res = "";
        	if (remain == 0) {
        		for (String s : f)
        			res += s;
        		return res;
        	} else {
        		boolean flag = false;
        		int ind = map.get((int)remain);
        		int i = 0;
        		for (String s : f) {
        			if (!flag) {
        				if (s.equals("."))
        					flag = true;
        				res += s;
        			} else {
	        			if (i != ind)
	        				res += s;
	        			else {
	        				res += "(" + s;
	        			}
	        			i++;
        			}
        		}
        		res += ")";
        		return res;
        	}
        }
        String res = "";
        for (String s : f)
        	res += s;
        return res;
    }
}
