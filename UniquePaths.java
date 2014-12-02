package cn.edu.sjtu.zzang;

public class UniquePaths {
	public static void main(String[] args) {
		UniquePaths up = new UniquePaths();
		System.out.println(up.uniquePaths(23, 12));
	}

	//res[m][n] = res[m-1][n-1]+res[m-2][n-1]+...+res[0][n-1] + res[m-1][n-1]+res[m-1][n-2]+...+res[m-1][0]
	public int uniquePaths(int m, int n) {
		int[][] res = new int[m][n];
		res[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0)
					res[i][j] = 1;
				else if (j == 0)
					res[i][j] = 1;
				else {
					for (int p = 0; p < i; p++)
						res[i][j] += res[p][j - 1];
					for (int q = 0; q < j; q++)
						res[i][j] += res[i - 1][q];
				}
			}
		}
		return res[m - 1][n - 1];
	}
	//cause time out
//    public int uniquePaths(int m, int n) {
//        return worker(0, 0, m, n);
//    }
//    
//    private int worker(int row, int col, int m, int n) {
//    	if (row == m - 1 && col == n -1)
//    		return 1;
//    	if (row == m - 1)
//    		return worker(row, col + 1, m, n);
//    	else if (col == n - 1)
//    		return worker(row + 1, col, m, n);
//    	else
//    		return worker(row, col + 1, m, n) + worker(row + 1, col, m, n);
//    }
}
