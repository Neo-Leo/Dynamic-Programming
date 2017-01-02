/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */ 

public class BestTimeToBuyAndSellWithCooldown {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0; 
        int n = prices.length; 
        int[] buy = new int[n]; 
        int[] sell = new int[n]; 
        buy[0] = -prices[0]; 
        buy[1] = Math.max(-prices[0],-prices[1]);
        sell[0] = 0; 
        sell[1] = Math.max(0,prices[1]-prices[0]); 
        for(int i=2; i<=n-1; i++){
            buy[i] = Math.max(buy[i-1], sell[i-2]-prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]); 
        }
        return sell[n-1]; 
    }
}