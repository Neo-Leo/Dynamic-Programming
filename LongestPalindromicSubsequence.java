/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 */ 

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) return 0; 
        if(s.length() == 1) return 1; 
        int[][] DP = new int[s.length()][s.length()];
        int n=s.length();
        for(int len=1; len<=n; len++){
            for(int i=0; i<=n-len; i++){
                int j=i+len-1; 
                if(i == j) {
                    DP[i][j] = 1; 
                } else {
                    if(s.charAt(i) == s.charAt(j)) DP[i][j] = 2 + DP[i+1][j-1]; 
                    else DP[i][j] = Math.max(DP[i+1][j], DP[i][j-1]); 
                }
            }
        }
        return DP[0][n-1]; 
    }
}