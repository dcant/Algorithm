package cn.edu.sjtu.zzang;

public class SpiralMatrixII {
	public static void main(String[] args) {
		SpiralMatrixII sm = new SpiralMatrixII();
		int[][] res = sm.generateMatrix(3);
		for (int[] row : res) {
			for (int i : row)
				System.out.print(i);
			System.out.println();
		}
	}

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int row = n, col = n;
        int p = 0, q = 0;
        int k = 1;
        while (p < row && q < col) {
        	for (int i = q; i < col; i++)
        		res[p][i] = k++;
        	p++;
        	for (int i = p; i < row; i++)
        		res[i][col - 1] = k++;
        	col--;
        	for (int i = col - 1; i >=q; i--)
        		res[row - 1][i] = k++;
        	row--;
        	for (int i = row - 1; i >= p; i--)
        		res[i][q] = k++;
        	q++;
        }
        return res;
    }
}
