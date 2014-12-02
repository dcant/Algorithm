package cn.edu.sjtu.zzang;

public class JumpGameII {
	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		int[] A = {2, 3, 1, 1, 1, 4};
		System.out.println(jg.jump(A));
	}

    public int jump(int[] A) {
        if (A == null || A.length < 2)
        	return 0;
        int maxReach = 0;
        int tmpReach = 0;
        int step = 0;
        for (int i = 0; i < A.length;) {
        	if (maxReach >= A.length - 1)
        		break;
        	while (i <= maxReach) {
        		tmpReach = tmpReach > (i + A[i]) ? tmpReach : (i + A[i]);
        		i++;
        	}
        	maxReach = tmpReach;
        	step++;
        }
        return step;
    }
}
