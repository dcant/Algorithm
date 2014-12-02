package cn.edu.sjtu.zzang;

public class RotateImage {
	public static void main(String[] args) {
		RotateImage ri = new RotateImage();
		int[][] mt = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		ri.rotate(mt);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < mt[0].length; j++)
				System.out.print(mt[i][j]);
			System.out.println();
		}
	}

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (matrix == null || row <= 1)
        	return;
        for (int i = 0; i < row / 2; i++) {
        	for (int j = 0; j < Math.ceil(((double)col) / 2.0); j++) {
        		int tmp = matrix[i][j];
        		matrix[i][j] = matrix[row - j - 1][i];
        		matrix[row - j - 1][i] = matrix[col - i - 1][row - j - 1];
        		matrix[col - i - 1][row - j - 1] = matrix[j][col - i - 1];
        		matrix[j][col - i - 1] = tmp;
        	}
        }
    }
}
