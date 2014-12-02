package cn.edu.sjtu.zzang;

public class MinimumPathSum {
	public static void main(String[] args) {
		MinimumPathSum mps = new MinimumPathSum();
		int[][] grid = {{1, 2, 3}, {2, 1, 3}, {2, 3, 1}};
		System.out.println(mps.minPathSum(grid));
	}

    public int minPathSum(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
        int[][] res = new int[m][n];
        res[0][0] = grid[m - 1][n - 1];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int min = Integer.MAX_VALUE;
        		int count = grid[m - 1 - i][n - 1 - j];
        		int curTotal = 0;
        		if (i == 0 && j == 0) {
        			min = grid[m - 1 - i][n - 1 - j];
        		} else if (i == 0) {
        			curTotal = grid[m - 1 - i][n - 1 - j] + res[i][j - 1];
        			if (curTotal < min)
        				min = curTotal;
        		} else if (j == 0) {
        			curTotal = grid[m - 1 - i][n - 1 - j] + res[i - 1][j];
        			if (curTotal < min)
        				min = curTotal;
        		} else {
	        		for (int p = i - 1; p >= 0; p--) {
	        			count += grid[m - 1 - p][n - 1 - j];
	        			curTotal = count + res[p][j - 1];
	        			if (curTotal < min)
	        				min = curTotal;
	        		}
	        		count = grid[m - 1 - i][n - 1 - j];
	        		curTotal = 0;
	        		for (int q = j - 1; q >= 0; q--) {
	        			count += grid[m - 1 - i][n - 1 - q];
	        			curTotal = count + res[i - 1][q];
	        			if (curTotal < min)
	        				min = curTotal;
	        		}
        		}
        		res[i][j] = min;
        	}
        }
        return res[m - 1][n - 1];
    }
}
