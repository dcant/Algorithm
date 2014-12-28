package cn.edu.sjtu.zzang;

public class ExcelSheetColumnNumber {
	public static void main(String[] args) {
		ExcelSheetColumnNumber esc = new ExcelSheetColumnNumber();
		System.out.println(esc.titleToNumber("AB"));
	}
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0)
        	return 0;
        int res = 0;
        for (int i = 0, len = s.length(); i < len; i++) {
        	res *= 26;
        	res += s.charAt(i) - 'A' + 1;
        }
        return res;
    }
}
