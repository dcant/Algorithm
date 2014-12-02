package cn.edu.sjtu.zzang;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		int[] sequence = {1, 7, 3, 5, 9, 4, 8};
		System.out.println(lis.longestSubsequence(sequence));
	}

	public int longestSubsequence(int[] sequence) {
		int[] inter = new int[sequence.length];
		inter[0] = sequence[0];
		int len = 0;
		for (int i = 0; i < sequence.length; i++) {
			if (sequence[i] > inter[len])
				inter[++len] = sequence[i];
			else {
				int k = find(inter, sequence[i], 0, len);
				inter[k] = sequence[i];
			}
		}
		return len + 1;
	}
	private int find(int[] array, int v, int lo, int hi) {
		if (lo == hi)
			return lo;
		int mid = (lo + hi) >> 1;
		if (array[mid] < v)
			return find(array, v, mid + 1, hi);
		else
			return find(array, v, lo, mid);
	}
}
