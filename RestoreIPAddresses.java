package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static void main(String[] args) {
		RestoreIPAddresses r = new RestoreIPAddresses();
		String s = "010010";
		List<String> res = r.restoreIpAddresses(s);
		for (String t: res)
			System.out.println(t);
	}

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        int[] ind = new int[3];
        worker(ind, 0, 1, s, res);
        return res;
    }
    
    private void worker(int[] ind, int count, int lo, String s, List<String> res) {
    	if (count == 3) {
    		String tmp = s.substring(0, ind[0]);
    		tmp += "." + s.substring(ind[0], ind[1]) + "." + s.substring(ind[1], ind[2]) + "." + s.substring(ind[2]);
    		res.add(tmp);
    	} else {
    		for (int i = lo; i < lo + 3 && i < (s.length() + count - 2); i++) {
    			if (count == 0) {
    				if (!isValid(s.substring(0, i)))
    					continue;
    			} else {
    				if (!isValid(s.substring(ind[count - 1], i)))
    					continue;
    				if (count == 2 && (s.length() - i > 3 ||!isValid(s.substring(i))))
    					continue;
    			}
    			ind[count] = i;
    			worker(ind, count + 1, i + 1, s, res);
    		}
    	}
    }
    
    private boolean isValid(String s) {
    	if (s.length() > 1 && s.charAt(0) == '0')
    		return false;
    	int v = Integer.valueOf(s);
    	if (v >= 0 && v <=255)
    		return true;
    	else
    		return false;
    }
}
