package cn.edu.sjtu.zzang;

import java.util.ArrayList;

public class BestTimeToBuyAndSellStockIV {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockIV btt = new BestTimeToBuyAndSellStockIV();
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(btt.maxProfit(2, prices));
	}
//    public int maxProfit(int k, int[] prices) {
//        if (prices == null || prices.length == 0)
//        	return 0;
//        if (k >= prices.length / 2)
//        	return maxOfall(prices);
//
//        int[][] profits = new int[2][prices.length + 1];
//        int curmax = -Integer.MAX_VALUE;
//        for (int i = 1; i <= k; i++) {
//        	profits[i%2][0] = 0;
//        	for (int j = 0; j < prices.length; j++) {
//        		profits[i%2][j + 1] = Math.max(profits[(i-1)%2][j + 1], Math.max(profits[i%2][j], prices[j] + curmax));
//        		curmax = Math.max(curmax, profits[(i - 1)%2][j] - prices[j]);
//        	}
//        }
//        return profits[k%2][prices.length];
//    }

    private int maxOfall(int[] prices) {
    	int sum = 0;
    	for (int i = 1; i < prices.length; i++) {
    		if (prices[i] > prices[i - 1])
    			sum += prices[i] - prices[i - 1];
    	}
    	return sum;
    }

    public int maxProfit(int k, int[] prices) {
        if (prices.length<2 || k<=0) return 0;
        if (k >= prices.length / 2)
        	return maxOfall(prices);
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        for(int i=0;i<prices.length-1;i++) {
            int diff = prices[i+1]-prices[i];
            for(int j=k;j >= 1;j--) {
                local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
                global[j] = Math.max(local[j],global[j]);
            }
        }
        return global[k];
    }
}
