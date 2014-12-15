package cn.edu.sjtu.zzang;

public class GasStation {
	public static void main(String[] args) {
		
	}

    public int canCompleteCircuit(int[] gas, int[] cost) {
    	int num = gas.length;
    	int remain = 0;
    	int sum = 0;
    	int res = 0;
    	for (int i = 0; i < num; i++) {
    		remain += gas[i] - cost[i];
    		sum += gas[i] - cost[i];
    		if (remain < 0) {
    			remain = 0;
    			res = i + 1;
    		}
    	}
    	if (sum >= 0)
    		return res;
    	return -1;
    }
}
