package cn.edu.sjtu.zzang;

import java.util.LinkedList;

public class LargestRectangleInHistogram {
	public static void main(String[] args) {
		LargestRectangleInHistogram lri = new LargestRectangleInHistogram();
		int[] height = {2,1,2};
		System.out.println(lri.largestRectangleArea(height));
	}

	public int largestRectangleArea(int[] height) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int i = 0;
		int max = 0;
		while (i < height.length) {
			if (stack.isEmpty() || height[i] >= height[stack.peek()])
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
