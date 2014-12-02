package cn.edu.sjtu.zzang;

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
		System.out.println(ub.numTrees(3));
	}

	/*
	 * trees[n] is the number of trees with exactly n nodes. There is 1 trees with 0 nodes, hence  trees[0] == 1.
	 * For a given n > 0 there is a root node and two children trees whose total size is: n-1
	 * trees[n-1] possible trees on the left and trees[0] on the right
	 * trees[n-2] possible trees on the left and trees[1] on the right
	 * ...
	 * trees[1] possible trees on the left and trees[n-1-1] on the right
	 * trees[0] possible trees on the left and trees[n-1] on the right
	 */
	
    public int numTrees(int n) {
        int[] res = new int[n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; i++)
        	for (int j = 0; j < i; j++)
        		res[i] += res[i - j - 1] * res[j];
        return res[n];
    }
}
