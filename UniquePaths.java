//Using DFS Recusrsion and DP to memorise the sum and avoid repeated calculation
TC:O(m*n)
SC:O(m*n)
succefully run on leetcode


class Solution {
    int [][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m+1][n+1];
        return helper(0,0,m,n);
    }
    public int helper(int i,int j,int m,int n){
        //base condition
        if(i==m-1 && j==n-1) return 1;
        if(i==m || j==n) return 0;
       
        //logic
        int right;
        if(dp[i][j+1]==0){
             dp[i][j+1] = helper(i,j+1,m,n);
        }
        right = dp[i][j+1];
        int bottom;
        if(dp[i+1][j]==0){
            dp[i+1][j] = helper(i+1,j,m,n);
        }
        bottom = dp[i+1][j];
        return right + bottom;
    }
}