package cn.edu.sjtu.zzang;

public class ExcelSheetColumnTitle {
	public static void main(String[] args) {
		ExcelSheetColumnTitle esc = new ExcelSheetColumnTitle();
		System.out.println(esc.convertToTitle(26));
	}
    public String convertToTitle(int n) {
        if (n < 0)
        	return null;
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
        	sb.append((char)('A' + (n - 1) % 26));
        	n = (n -1) /26;
        }
        return sb.reverse().toString();
    }
}
