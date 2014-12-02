package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		
	}

    public void setZeroes(int[][] matrix) {
    	ArrayList<int[]> flag = new ArrayList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
        	for (int j = 0; j < matrix[0].length; j++) {
        		if (matrix[i][j] == 0) {
        			int[] item = new int[2];
        			item[0] = i;
        			item[1] = j;
        			flag.add(item);
        		}
        	}
        }
        for (int[] item : flag) {
        	for (int i = 0; i < matrix[0].length; i++)
        		matrix[item[0]][i] = 0;
        	for (int i = 0; i < matrix.length; i++)
        		matrix[i][item[1]] = 0;
        }
    }
}
