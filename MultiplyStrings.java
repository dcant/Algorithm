package cn.edu.sjtu.zzang;

public class MultiplyStrings {
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		System.out.println(ms.multiply("1111", "0"));
	}

    public String multiply(String num1, String num2) {
        String one = new StringBuilder(num1).reverse().toString();
        String two = new StringBuilder(num2).reverse().toString();
        int n1 = num1.length();
        int n2 = num2.length();
        int[] mul = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
        	for (int j = 0; j < n2; j++) {
        		mul[i + j] += (one.charAt(i) - '0') * (two.charAt(j) - '0');
        	}
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < mul.length; i++) {
        	int carry = mul[i] / 10;
        	int cur = mul[i] % 10;
        	if (i + 1 < mul.length)
        		mul[i + 1] += carry;
        	res.insert(0, cur);
        }
        while (res.charAt(0) == '0' && res.length() > 1)
        	res.deleteCharAt(0);
        return res.toString();
    }
}
