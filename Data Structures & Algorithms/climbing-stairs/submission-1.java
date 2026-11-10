class Solution {
    int[] dp = new int[] {2, 1};
    public int climbStairs(int n) {
        for (int i = 3; i <= n; i++) {
            dp[i & 1] += dp[(i + 1) & 1]; 
        } 
        return dp[n & 1];
    }
}
