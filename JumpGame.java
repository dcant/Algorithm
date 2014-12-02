package cn.edu.sjtu.zzang;

public class JumpGame {
	public static void main(String[] args) {
		
	}

    public boolean canJump(int[] A) {
        if (A == null || A.length == 0)
        	return false;
        int maxReach = 0;
        int step = 1;
        for (int i = 0; i < A.length; i++) {
        	if (maxReach >= A.length - 1)
        		return true;
        	step--;
        	if (i + A[i] > maxReach) {
        		maxReach = i + A[i];
        		step = A[i];
        	}
        	if (step == 0 & maxReach < A.length - 1)
        		return false;
        }
        return true;
    }
}
