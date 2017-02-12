/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */ 

// DFS
/*
public class Solution {
    public boolean wrapper(int[] nums, int start, int sum){
        if(sum < 0) return false; 
        
        if(sum == 0) {
            return true; 
        }
        
        for(int i=start; i<=nums.length-1; i++){
            sum = sum - nums[i];
            boolean result = wrapper(nums,i+1,sum); 
            if(result) return true; 
            sum = sum + nums[i];
        }
        
        return false; 
    }
    
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int elem : nums){
            sum+=elem; 
        }
        if(sum%2 != 0) return false; 
        Arrays.sort(nums); 
        boolean result = wrapper(nums,0,sum/2);
        return result;
    }
}
*/


// 0/1 Knapsack 
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for(int elem : nums){
            sum+=elem; 
        }
        if(sum%2 != 0) return false; 
        sum = sum/2; 
        boolean[][] DP = new boolean[nums.length+1][sum+1]; 
        for(int i=0; i<=nums.length; i++) DP[i][0] = true; 
        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=sum;j++){
                if(j>=nums[i-1]) {
                    DP[i][j] = (DP[i-1][j] || DP[i-1][j-nums[i-1]]); 
                } else {
                    DP[i][j] = DP[i-1][j];
                }
            }
        }
        return DP[nums.length][sum];
    }
}