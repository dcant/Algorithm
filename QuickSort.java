package cn.edu.sjtu.zzang;

public class QuickSort {
	public int[] array;
	public static void main(String[] args) {
		int[] n = {2, 1, 4, 5, 3, 7, 6};
		QuickSort qs = new QuickSort(n);
		int[] result = qs.sort();
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
		
	}
	
	public QuickSort(int[] data) {
		this.array = data;
	}

	public int[] sort() {
		quickSort(0, array.length - 1);
		return this.array;
	}
	private void quickSort(int start, int end) {
		int lo = start;
		int hi = end;
		if (start > end)
			return;
		int pivot = array[start];
		while (lo != hi) {
			while (array[hi] >= pivot && hi > lo)
				hi--;
			if (hi > lo)
				array[lo++] = array[hi];
			while (array[lo] <= pivot && hi > lo)
				lo++;
			if (hi > lo)
				array[hi--] = array[lo];
		}
		array[lo] = pivot;
		quickSort(start, lo - 1);
		quickSort(lo + 1, end);
	}
}
