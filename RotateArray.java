package cn.edu.sjtu.zzang;

public class RotateArray {
	public static void main(String[] args) {
		RotateArray ra = new RotateArray();
		int[] nums = {1,2,3,4,5,6,7};
		ra.rotate(nums, 3);
		for (int item : nums)
			System.out.println(item);
	}
	
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0)
        	return;
        int move = k % nums.length;
        if (move == 0)
        	return;
        reverse(nums, 0, nums.length - move - 1);
        reverse(nums, nums.length - move, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int lo, int hi) {
    	while (lo < hi) {
    		int temp = nums[lo];
    		nums[lo] = nums[hi];
    		nums[hi] = temp;
    		lo++;
    		hi--;
    	}
    }
}
