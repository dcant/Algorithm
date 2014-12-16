package cn.edu.sjtu.zzang;

public class Candy {
	public static void main(String[] args) {
		Candy c = new Candy();
		int[] ratings = {2,1,3,1,4};
		System.out.println(c.candy(ratings));
	}
    public int candy(int[] ratings) {
    	if (ratings == null || ratings.length == 0)
    		return 0;
        int[] left = new int[ratings.length]; // memorize ascending number before each i
        int[] right = new int[ratings.length]; //memorize ascending number before each i in reverse order
        left[0] = 0;
        right[ratings.length - 1] = 0;
        int k = 0;
        for (int i = 1; i < ratings.length; i++) {
        	if (ratings[i] > ratings[i - 1]) {
        		k++;
        		left[i] = k;
        	} else {
        		k = 0;
        		left[i] = 0;
        	}
        }
        k = 0;
        for (int i = ratings.length - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i + 1]) {
        		k++;
        		right[i] = k;
        	} else {
        		k = 0;
        		right[i] = 0;
        	}
        }
        int count = 0;
        for (int i = 0; i < ratings.length; i++) {
        	count += Math.max(left[i], right[i]) + 1;
        }
        return count;
    }
}
