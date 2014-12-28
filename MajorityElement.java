package cn.edu.sjtu.zzang;

public class MajorityElement {
	public static void main(String[] args) {
		MajorityElement me = new MajorityElement();
		int[] num = {2,1,2,1,1};
		System.out.println(me.majorityElement(num));
	}
    public int majorityElement(int[] num) {
        int counter = 1;
        int element = num[0];
        for (int i = 1; i < num.length; i++) {
        	if (counter == 0) {
        		element = num[i];
        		counter++;
        	} else {
        		if (element == num[i])
        			counter++;
        		else
        			counter--;
        	}
        }
        return element;
    }
}
