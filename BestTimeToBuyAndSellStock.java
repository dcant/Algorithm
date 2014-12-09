package cn.edu.sjtu.zzang;

public class BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStock btt = new BestTimeToBuyAndSellStock();
		int[] prices = {31, 25, 17, 16, 31, 10};
		System.out.println(btt.maxProfit(prices));
	}
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE, maxprofit = 0, high = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < low) {
        		low = prices[i];
        		high = prices[i];
        	} else if (prices[i] > high) {
        		high = prices[i];
        		if (high - low > maxprofit)
        			maxprofit = high - low;
        	}
        }
        return maxprofit;
    }
}
