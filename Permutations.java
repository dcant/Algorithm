package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class Permutations {
	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] num = {1,2,3};
		ArrayList<ArrayList<Integer>> res = p.permute(num);
		for (ArrayList<Integer> item : res) {
			for (int i : item) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	//从空序列开始不断往里边不同位置填充数字，直到数字用完
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> item : res) {
				for (int k = 0; k < item.size() + 1; k++) {
					item.add(k, num[i]);
					tmp.add(new ArrayList<Integer>(item));
					item.remove(k);
				}
			}
			res = new ArrayList<ArrayList<Integer>>(tmp);
		}
		return res;
	}
	
//    public ArrayList<ArrayList<Integer>> permute(int[] num) {
//        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//        worker(num, 0, res);
//        return res;
//    }
//    
//    private void worker(int[] num, int lo, ArrayList<ArrayList<Integer>> res) {
//    	if (lo >= num.length) {
//    		ArrayList<Integer> item = addToList(num);
//    		res.add(item);
//    	}
//    	for (int i = lo; i < num.length; i++) {
//    		swap(num, lo, i);
//    		worker(num, lo + 1, res);
//    		swap(num, lo, i);
//    	}
//    }
//    
//    private ArrayList<Integer> addToList(int[] num) {
//    	ArrayList<Integer> res = new ArrayList<Integer>();
//    	for (int i : num) {
//    		res.add(i);
//    	}
//    	return res;
//    }
//    
//    private void swap(int[] num, int i, int j) {
//    	int tmp = num[i];
//    	num[i] = num[j];
//    	num[j] = tmp;
//    }
}
