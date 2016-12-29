/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/guess-number-higher-or-lower-ii/
 */ 

public class GuessNumberHigherOrLowerII {
    public int getMoneyAmount(int n) {
       if(n<=1) return 0; 
       int[][] DP = new int[n][n]; 
       for(int len=2; len<=n; len++) {
           for(int i=0; i<=n-len; i++) {
               int j = i+len-1;
               int minVal = Integer.MAX_VALUE; 
               for(int k=i; k<=j; k++){
                   minVal = Math.min(minVal, k + 1 + Math.max((k==i ? 0 : DP[i][k-1]), (k==j ? 0 : DP[k+1][j]))); 
               }
               DP[i][j] = minVal; 
           }
       }
       return DP[0][n-1];
    }
}