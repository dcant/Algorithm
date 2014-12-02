package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
	public static void main(String[] args) {
		NQueens nq = new NQueens();
		List<String[]> res = nq.solveNQueens(1);
		for (String[] ans : res) {
			for (String str : ans)
				System.out.println(str);
			System.out.println();
		}
	}
	
    public List<String[]> solveNQueens(int n) {
    	ArrayList<String[]> res = new ArrayList<String[]>();
        if (n == 0)
        	return res;
        int[] place = new int[n];
        worker(place, 0, res);
        return res;
    }
    
    private void worker(int[] place, int curRow, ArrayList<String[]> res) {
    	if (curRow == place.length) {
    		String[] holder = new String[place.length];
    		char[] row = new char[place.length];
    		for (int i = 0; i < place.length; i++) {
    			Arrays.fill(row, '.');
    			row[place[i]] = 'Q';
    			holder[i] = String.copyValueOf(row);
    		}
    		res.add(holder);
    		return;
    	}
    	for (int i = 0; i < place.length; i++) {
    		if (isValid(place, curRow, i)) {
				place[curRow] = i;
				worker(place, curRow + 1, res);
    		}
    	}
    }
    
    private boolean isValid(int[] place, int curRow, int col) {
		for (int j = 0; j < curRow; j++) {
			if (place[j] == col || Math.abs(place[j] - col) == Math.abs(j - curRow))
				return false;
		}
		return true;
    }
}
