/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/burst-balloons/
 */ 

//Diagonal DP
public class BurstBalloons {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0; 
        if(nums.length == 1) return nums[0];
        int n = nums.length; 
        int[][] DP = new int[n][n]; 
        for(int len=1; len<=n; len++) {
            for(int i=0; i<=n-len; i++) {
                int j = i+len-1;
                int maxVal = 0;
                for(int k=i; k<=j; k++) { // This is a streak between i and j 
                    int streakLeft = 1, streakRight = 1;
                    if(i != 0) streakLeft = nums[i-1];
                    if(j != n-1) streakRight = nums[j+1]; 
                    int localLeft=0, localRight=0; 
                    if(k != i) localLeft = DP[i][k-1];
                    if(k != j) localRight = DP[k+1][j]; 
                    maxVal = Math.max(maxVal, localLeft + localRight + streakLeft * nums[k] * streakRight); 
                }
                DP[i][j] = maxVal; 
            }
        }
        return DP[0][n-1]; 
    }
}
