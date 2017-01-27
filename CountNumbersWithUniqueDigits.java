/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/count-numbers-with-unique-digits/
 */ 

// O(n^2) for n<=10

public class CountNumbersWithUniqueDigits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n >= 11) n = 10; 
        int[] DP = new int[n+1];
        DP[0] = 1;
        for(int i=1; i<=n; i++){
            int total=1, iterator=9; 
            for(int j=1; j<=i; j++){
                if(j<=2){
                    total *= iterator;  
                } else {
                    iterator--;
                    total *= iterator;
                }
            }
            DP[i] = DP[i-1] + total; 
        }
        return DP[n];
    }
}