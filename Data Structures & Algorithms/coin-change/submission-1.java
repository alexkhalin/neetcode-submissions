class Solution {
    private static final int NOT_FOUND = Integer.MAX_VALUE - 1;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, NOT_FOUND);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin: coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] != NOT_FOUND ? dp[amount] : -1;
    }
}
