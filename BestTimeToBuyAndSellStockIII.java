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
}
