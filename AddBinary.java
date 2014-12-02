package cn.edu.sjtu.zzang;

public class AddBinary {
	public static void main(String[] args) {
		AddBinary ab = new AddBinary();
		System.out.println(ab.addBinary("1110", "101"));
	}

    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        StringBuilder sba = new StringBuilder(a).reverse();
        StringBuilder sbb = new StringBuilder(b).reverse();
        int k = Math.min(alen, blen);
        char carry = '0';
        for (int i = 0; i < k; i++) {
        	if (sba.charAt(i) == '0') {
        		if (sbb.charAt(i) == '0') {
        			sb.append(carry);
        			carry = '0';
        		} else {
        			if (carry == '1') {
        				carry = '1';
        				sb.append('0');
        			} else {
        				carry = '0';
        				sb.append('1');
        			}
        		}
        	} else {
        		if (sbb.charAt(i) == '1') {
        			if (carry == '1') {
        				carry = '1';
        				sb.append('1');
        			} else {
        				carry = '1';
        				sb.append('0');
        			}
        		} else {
        			if (carry == '1') {
        				carry = '1';
        				sb.append('0');
        			} else {
        				carry = '0';
        				sb.append('1');
        			}
        		}
        	}
        }
        if (alen < blen) {
        	for (int i = alen; i < blen; i++) {
        		if (sbb.charAt(i) == '1') {
        			if (carry == '1') {
        				carry = '1';
        				sb.append('0');
        			} else {
        				carry = '0';
        				sb.append('1');
        			}
        		} else {
        			sb.append(carry);
        			carry = '0';
        		}
        	}
        } else if (alen > blen) {
        	for (int i = blen; i < alen; i++) {
        		if (sba.charAt(i) == '1') {
        			if (carry == '1') {
        				carry = '1';
        				sb.append('0');
        			} else {
        				carry = '0';
        				sb.append('1');
        			}
        		} else {
        			sb.append(carry);
        			carry = '0';
        		}
        	}
        }
        if (carry == '1')
        	sb.append(carry);
        return sb.reverse().toString();
    }
}
