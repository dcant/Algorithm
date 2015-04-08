package cn.edu.sjtu.zzang;

public class BestTimeToBuyAndSellStockIII {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII bt = new BestTimeToBuyAndSellStockIII();
		int[] prices = {6,1,3,2,4,7};//{23, 25, 18, 24, 16, 19, 17};
		System.out.println(bt.maxProfit(prices));
	}
    public int maxProfit(int[] prices) {
    	if (prices == null || prices.length == 0)
    		return 0;
    	int[] left = new int[prices.length];
    	int[] right = new int[prices.length];
    	int min = prices[0];
    	for (int i = 1; i < prices.length; i++) {
    		left[i] = left[i - 1] > prices[i] - min ? left[i - 1] : prices[i] - min;
    		min = min < prices[i] ? min : prices[i];
    	}
    	int max = prices[prices.length - 1];
    	for (int i = prices.length - 2; i >= 0; i--) {
    		right[i] = right[i + 1] > max - prices[i] ? right[i + 1] : max - prices[i];
    		max = max > prices[i] ? max : prices[i];
    	}
    	int maxprofit = 0;
    	for (int i = 0; i < prices.length; i++)
    		if (left[i] + right[i] > maxprofit)
    			maxprofit = left[i] + right[i];
    	return maxprofit;
    }
   
    //·½·¨¶þ£º
//    public int maxProfit(int[] prices) {
//        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
//        int release1 = 0, release2 = 0;
//        for(int i:prices){                              // Assume we only have 0 money at first
//            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
//            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
//            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
//            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far. 
//        }
//        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
//    }
}
