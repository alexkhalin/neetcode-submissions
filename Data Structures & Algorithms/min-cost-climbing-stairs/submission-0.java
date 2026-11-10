class Solution {
    int[] dp = new int[2];
    public int minCostClimbingStairs(int[] cost) {
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i & 1] = Math.min(dp[0], dp[1]) + cost[i];
        }

        return Math.min(dp[0], dp[1]);
    }
}
