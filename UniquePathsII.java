package cn.edu.sjtu.zzang;

public class UniquePathsII {
	public static void main(String[] args) {
		UniquePathsII up = new UniquePathsII();
		int[][] obstacleGrid = {{0,0,0,0,0}, {0,0,0,0,1}, {0,0,0,1,0}, {0,0,1,0,0}};
		System.out.println(up.uniquePathsWithObstacles(obstacleGrid));
	}

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
		int[][] res = new int[m][n];
		if (obstacleGrid[m - 1][n - 1] == 1)
			return 0;
		res[0][0] = 1;
		boolean flagr = false;
		boolean flagc = false;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					if (obstacleGrid[m - 1 - i][n - 1 - j] == 1 || flagr) {
						res[i][j] = 0;
						flagr = true;
					} else
						res[i][j] = 1;
				} else if (j == 0) {
					if (obstacleGrid[m - 1 - i][n - 1 - j] == 1 || flagc){
						res[i][j] = 0;
						flagc = true;
					} else
						res[i][j] = 1;
				} else {
					if (obstacleGrid[m - 1 - i][n - 1 - j] == 1)
						res[i][j] = 0;
					else {
						for (int p = i - 1; p >= 0; p--) {
							if (obstacleGrid[m - 1 - p][n - 1 - j] == 1)
								break;
							res[i][j] += res[p][j - 1];
						}
						for (int q = j - 1; q >= 0; q--) {
							if (obstacleGrid[m - 1 - i][n - 1 - q] == 1)
								break;
							res[i][j] += res[i - 1][q];
						}
					}
				}
			}
		}
		return res[m - 1][n - 1];
    }
}
