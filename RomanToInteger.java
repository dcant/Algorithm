package cn.edu.sjtu.zzang;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public static void main(String[] args) {
		RomanToInteger rti = new RomanToInteger();
		System.out.println(rti.romanToInt("MDCCCXCIX"));
	}
    public int romanToInt(String s) {
		Map<Character, Integer> Roman = new HashMap<Character, Integer>();
		Roman.put('I', 1);
		Roman.put('V', 5);
		Roman.put('X', 10);
		Roman.put('L', 50);
		Roman.put('C', 100);
		Roman.put('D', 500);
		Roman.put('M', 1000);
		int result = 0;
		char[] tmp = s.toCharArray();
		for (int i = 0; i < tmp.length; i++) {
			int val = Roman.get(tmp[i]);
			if (i == tmp.length - 1 || Roman.get(tmp[i + 1]) <= val)
				result += val;
			else
				result -= val;
		}
		return result;
    }
}
