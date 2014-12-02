package cn.edu.sjtu.zzang;

public class SearchA2DMatrix {
	public static void main(String[] args) {
		SearchA2DMatrix sa = new SearchA2DMatrix();
		int[][] matrix = {{1}};//{{1,   3,  5,  7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(sa.searchMatrix(matrix, 0));
	}

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length - 1; i++) {
        	if (matrix[i][0] > target)
        		return false;
        	else if (matrix[i][0] == target)
        		return true;
        	else if (matrix[i][0] < target && matrix[i + 1][0] > target){
        		int lo = 0, hi = matrix[0].length - 1;
        		while (lo <= hi) {
        			int mid = (lo + hi)/2;
        			if (matrix[i][mid] == target)
        				return true;
        			else if (matrix[i][mid] > target)
        				hi = mid - 1;
        			else
        				lo = mid + 1;
        		}
        		return false;
        	}
        }
        int lo = 0, hi = matrix[0].length - 1;
        while (lo <= hi) {
        	int mid = (lo + hi)/2;
        	if (matrix[matrix.length - 1][mid] == target)
        		return true;
        	else if (matrix[matrix.length - 1][mid] > target)
        		hi = mid - 1;
        	else
        		lo = mid + 1;
        }
        return false;
    }
}
