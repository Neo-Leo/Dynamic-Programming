/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/ugly-number-ii/
 */ 

public class UglyNumber {
    public int nthUglyNumber(int n) {
        if(n <= 0) return 1;
        if(n == 1) return 1; 
        int[] DP = new int[n];
        DP[0] = 1; 
        int t2=0, t3=0, t5=0, nextMultiple=1; 
        for(int i=1;i<=n-1;i++){
            nextMultiple = Math.min(2*DP[t2], Math.min(3*DP[t3],5*DP[t5]));
            if(nextMultiple == 2*DP[t2]) t2++; 
            if(nextMultiple == 3*DP[t3]) t3++;
            if(nextMultiple == 5*DP[t5]) t5++;
            DP[i] = nextMultiple; 
        }
        return DP[n-1]; 
    }
}