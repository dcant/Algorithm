package cn.edu.sjtu.zzang;

public class BestTimeToBuyAndSellStockII {
	public static void main(String[] args) {
		BestTimeToBuyAndSellStockII btt = new BestTimeToBuyAndSellStockII();
		int[] prices = {20, 25, 17, 16, 31, 10};
		System.out.println(btt.maxProfit(prices));
	}
    public int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE, maxprofit = 0, high = 0, totalprofit = 0;
        for (int i = 0; i < prices.length; i++) {
        	if (prices[i] < low) {
        		low = prices[i];
        		high = prices[i];
        	} else if (prices[i] > high) {
        		high = prices[i];
        		if (high - low > maxprofit) {
        			maxprofit = high - low;
        			totalprofit += maxprofit;
        			low = high = prices[i];
        			maxprofit = 0;
        		}
        	}
        }
        return totalprofit;
    }
}
