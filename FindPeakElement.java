package cn.edu.sjtu.zzang;

public class FindPeakElement {
	public static void main(String[] args) {
		FindPeakElement fpe = new FindPeakElement();
		int[] num = {1,2,3,4};
		System.out.println(fpe.findPeakElement(num));
	}
    public int findPeakElement(int[] num) {
        if (num.length == 1)
        	return 0;
        int i = 1;
        while (i < num.length && num[i] > num[i - 1]) {
        	i++;
        }
        return i-1;
    }
}
