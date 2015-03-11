package cn.edu.sjtu.zzang;

import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] num) {
        String[] numbers = new String[num.length];
        for (int i = 0; i < num.length; i++)
        	numbers[i] = String.valueOf(num[i]);
        Arrays.sort(numbers, new java.util.Comparator<String>(){

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				String leftright = arg0.concat(arg1);
				String rightleft = arg1.concat(arg0);
				return leftright.compareTo(rightleft);
			}
        	
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; i++)
        	sb.append(numbers[i]);
        return new java.math.BigInteger(sb.toString()).toString();
    }
}
