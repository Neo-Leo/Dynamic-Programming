/*
 * Nilanshu Sharma
 * https://leetcode.com/problems/dungeon-game/
 */ 


public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0; //Dungeon does not exist 
        int m = dungeon.length, n=dungeon[0].length;
        int[][] need = new int[m][n];
        need[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1); 
        for(int i=m-2;i>=0;i--) //Last Column, there is only one way to reach -> from below
            need[i][n-1] = Math.max(need[i+1][n-1]-dungeon[i][n-1], 1);
        for(int i=n-2;i>=0;i--) //Last Row, there is only one way to reach -> from right
            need[m-1][i] = Math.max(need[m-1][i+1]-dungeon[m-1][i], 1);
        for(int i=m-2;i>=0;i--) { // Fill the rest of the table 
            for(int j=n-2;j>=0;j--) {
                int below = Math.max(need[i+1][j]-dungeon[i][j],1); //If coming from below
                int right = Math.max(need[i][j+1]-dungeon[i][j],1); //If coming from right
                need[i][j] = Math.min(below,right);
            }
        }
        return need[0][0];
    }
}