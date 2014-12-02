package cn.edu.sjtu.zzang;

import java.util.HashSet;
import java.util.Set;

public class ValidNumber {
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber(" 1"));
	}

	public boolean isNumber(String s) {
		String regx = "[+-]?(\\d+\\.?|\\.\\d+)\\d*((e|E)[+-]?\\d+)?";
		if (s.trim().matches(regx))
			return true;
		else
			return false;
	}
	
//    public boolean isNumber(String s) {
//        if(s == null || s.trim().length() == 0) return false;
//        s = s.trim();
//        char[] charArray = {'0','1','2','3','4','5','6','7','8','9','.','e','E','+','-'};
//        Set<Character> set = new HashSet<Character>();
//        for(char c : charArray){
//            set.add(c);
//        }
//        boolean hasE = false, hasPoint = false, hasNum = false;
//        int operaterCount = 0;
//        for(int i = 0; i < s.length(); i++){
//            if(!set.contains(s.charAt(i))) return false;
//            if(s.charAt(i) <= '9' && s.charAt(i) >= '0') hasNum = true;
//            if(s.charAt(i) == 'E' || s.charAt(i) == 'e'){
//                if(i == 0 || i == s.length() - 1) return false;
//                if(!hasE && hasNum) hasE = true;
//                else return false;
//            }
//            if(s.charAt(i) == '.'){
//                if(i == 0 && 1 == s.length()) return false;
//                if(i == s.length() - 1 && !hasNum) return false;
//                if(!hasPoint && !hasE) hasPoint = true;
//                else return false;
//            }
//            if(s.charAt(i) == '-' || s.charAt(i) == '+'){
//                if(i == s.length() - 1 || (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E')) return false;
//                if(operaterCount == 2) return false;
//                if(operaterCount == 1 && !hasE && !hasNum) return false;
//                operaterCount++;
//            }
//        }
//        return true;
//    }
}
