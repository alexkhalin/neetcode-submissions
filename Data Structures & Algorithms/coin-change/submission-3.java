class Solution {
    private static final int NOT_FOUND = Integer.MAX_VALUE - 1;
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        BitSet bs = new BitSet(amount + 1);
        Arrays.fill(dp, NOT_FOUND);
        dp[0] = 0;
        for (int coin: coins) {
            int end = amount - coin;
            for (int i = 0; i != -1 && i <= end; i = bs.nextSetBit(i + 1)) {
                int next = i + coin;
                dp[next] = Math.min(dp[i] + 1, dp[next]);
                bs.set(next);
            }
        }
        return dp[amount] != NOT_FOUND ? dp[amount] : -1;
    }
}
