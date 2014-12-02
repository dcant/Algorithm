package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = {{1,2,3}};
		List<Integer> res = sm.spiralOrder(matrix);
		for (int i : res)
			System.out.print(i);
	}

    public List<Integer> spiralOrder(int[][] matrix) {
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	if (matrix == null | matrix.length == 0)
    		return res;
        int n = matrix[0].length;
        int m = matrix.length;
        int p = 0, q = 0;
        while (p < m && q < n) {
        	for (int i = q; i < n; i++)
        		res.add(matrix[p][i]);
        	p++;
        	for (int i = p; i < m; i++)
        		res.add(matrix[i][n - 1]);
        	n--;
        	if (p < m) {
	        	for (int i = n - 1; i >= q; i--)
	        		res.add(matrix[m - 1][i]);
	        	m--;
        	}
        	if (q < n) {
	        	for (int i = m - 1; i >= p; i--)
	        		res.add(matrix[i][q]);
	        	q++;
        	}
        }
        return res;
    }
}
