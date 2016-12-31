/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/palindrome-partitioning-ii/
 */ 

public class PalindromePartitioningII {
    public int minCut(String s) {
        // One way is to do it via Diagonal DP and it costs O(n^3)
        // Here is another way to do this. It is O(n^2) 
        if(s == null || s.length() <= 1) return 0; 
        int n = s.length(); 
        int cost[] = new int[n]; 
        boolean[][] DP = new boolean[n][n]; 
        for(int j=0; j<=n-1; j++){
            int min = j; 
            for(int i=0; i<=j; i++){
                // i is the left boundary and j is the right boundary
                if((s.charAt(i) == s.charAt(j)) && (j-i <= 1 || DP[i+1][j-1])){
                    // S[i....j] is a palindrome, so 0 cost from there 
                    // Otherwise the cost is 1 + cost[0...i-1] 
                    DP[i][j] = true; 
                    min = (i == 0) ? 0 : Math.min(min, cost[i-1]+1);   
                }
            }
            cost[j] = min; 
        }
        return cost[n-1]; 
    }
}