package cn.edu.sjtu.zzang;

import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		LetterCombinationsOfAPhoneNumber lcoapn = new LetterCombinationsOfAPhoneNumber();
		LinkedList<String> res = lcoapn.letterCombinations("23");
		while (!res.isEmpty()) {
			String tmp = res.pop();
			System.out.println(tmp);
		}
	}
	
    public LinkedList<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> result = new LinkedList<String>();
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
        	int indx = digits.charAt(i) - '2';
        	int size = result.size();
        	for (int j = 0; j < size; j++) {
        		String tmp = result.pop();
        		for (int k = 0; k < letters[indx].length(); k++) {
        			result.add(tmp + letters[indx].charAt(k));
        		}
        	}
        }
        return result;
    }
}