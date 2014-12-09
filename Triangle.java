package cn.edu.sjtu.zzang;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int num = row * (row + 1) / 2;
        int[] res = new int[num];
        int i = 0;
        for (List<Integer> r : triangle) {
        	int j = 0;
        	int lo = i * (i + 1) / 2; // every row's first number's index in res;
        	for (int m : r) {
        		if (i != 0) {
        			if (j != 0 && j < i) {
        				res[lo + j] = m + Math.min(res[lo - i + j - 1], res[lo - i + j]);
        			} else if (j == 0)
        				res[lo] = m + res[lo - i];
        			else
        				res[lo + j] = m + res[lo - i + j - 1];
        		} else
        			res[0] = m;
        		j++;
        	}
        	i++;
        }
        int min = Integer.MAX_VALUE;
        for (i = num - row; i < num; i++) {
        	if (res[i] < min)
        		min = res[i];
        }
        return min;
    }
}
