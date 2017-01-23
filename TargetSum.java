/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/target-sum/
 */ 

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return 0; 
        int sum=0; 
        for(int elem : nums) sum += elem; 
        if(S > sum || S < -sum) return 0;
        int[] DP = new int[2*sum+1]; 
        DP[sum]=1;
        for(int i=0; i<=nums.length-1; i++){
            int[] next = new int[2*sum+1]; 
            for(int j=0; j<=2*sum ;j++) {
                if(DP[j] != 0) {
                    next[j-nums[i]] += DP[j]; 
                    next[j+nums[i]] += DP[j];
                }
                
            }
            DP = next; 
        }
        return DP[sum+S];
    }
}