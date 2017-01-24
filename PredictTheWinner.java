/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/predict-the-winner/
 */ 

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if(nums == null || nums.length == 0) return false; 
        if(nums.length%2 == 0) return true; 
        int n = nums.length; 
        int[][] DP = new int[n][n]; 
        for(int[] arr : DP){
            Arrays.fill(arr,-1);
        }
        int p1MaxScore = wrapper(nums,DP,0,n-1); 
        int sum = 0; 
        for(int num : nums) sum += num;
        return (p1MaxScore >= (sum-p1MaxScore)); 
    }
    
    public int wrapper(int[] nums, int[][] DP,int start, int end){
        if(end < start) return 0; 
        
        if(DP[start][end] != -1) return DP[start][end]; 
        
        int a = nums[start] + Math.min(wrapper(nums, DP, start+2, end), wrapper(nums, DP, start+1,end-1));
        int b = nums[end] + Math.min(wrapper(nums,DP, start+1,end-1), wrapper(nums, DP, start,end-2)); 

        DP[start][end] = Math.max(a,b);
        
        return DP[start][end];
    }
}