package cn.edu.sjtu.zzang;

import java.util.Stack;

public class MaximalRectangle {
	public static void main(String[] args) {
		MaximalRectangle mr = new MaximalRectangle();
		char[][] matrix = {{1,1},{1,1}};
		System.out.println(mr.maximalRectangle(matrix));
	}

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
        	return 0;
        int row = matrix.length, col = matrix[0].length;
        int max = 0;
        int area;
        int[][] height = new int[row][col];
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
        		if (i == 0)
        			height[i][j] = matrix[i][j] == '0' ? 0 : 1;
        		else
        			height[i][j] = matrix[i][j] == '0' ? 0 : 1 + height[i - 1][j];
        	}
        }
        for (int i = 0; i < row; i++) {
        	area = getMaxRec(height[i]);
        	if (area > max)
        		max = area;
        }
        return max;
    }
    
    private int getMaxRec(int[] height) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int i = 0;
    	int max = 0;
    	while (i < height.length) {
    		if (stack.isEmpty() || height[stack.peek()] <= height[i])
    			stack.push(i++);
    		else {
    			int h = stack.pop();
    			max = Math.max(max, height[h] * (stack.isEmpty() ? i : i - stack.peek() - 1));
    		}
    	}
    	while (!stack.isEmpty()) {
    		int h = stack.pop();
    		max = Math.max(max, height[h] * (stack.isEmpty() ? i : i - stack.peek() - 1));
    	}
    	return max;
    }
}
