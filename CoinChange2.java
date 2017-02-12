/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/coin-change-2/
 */ 

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        if(coins == null) return 0; 
        int[] DP = new int[amount+1]; 
        DP[0] = 1;
        for(int coin : coins){
            for(int i=1; i<=amount; i++) {
                if(i >= coin) DP[i] += DP[i-coin];
            }
        }
        return DP[amount]; 
    }
}