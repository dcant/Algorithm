package cn.edu.sjtu.zzang;

public class TwoSum2 {
	public static void main(String[] args) {
		int[] data = {2, 1, 5, 8, 4, 3, 9, 7, 6, 0};
		TwoSum2 ts = new TwoSum2();
		int[] res = ts.twoSum(data, 4);
		for (int i = 0; i < res.length; i = i+2) {
			System.out.print(res[i]);
			System.out.println(res[i+1]);
		}
	}
	
	public int[] twoSum(int[] numbers, int target) {
		int[] indexs = new int[numbers.length];
		int[] result = new QuickSort(numbers).sort();
		int lo = 0;
		int hi = numbers.length - 1;
		int k = 0;
		while ( lo < hi) {
			int tmp = result[lo] + result[hi];
			System.out.println(tmp);
			if (tmp > target)
				hi--;
			else if (tmp < target)
				lo++;
			else {
				indexs[k++] = lo;
				indexs[k++] = hi;
				lo++;
			}
		}
		return indexs;
	}
	
	class QuickSort {
		public int[] array;
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
}
