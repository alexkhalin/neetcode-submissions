class Solution {

    // Map<Long, Integer> cache = new HashMap<>();

    // private int dfs(int[] nums, int idx, int prev) {
    //     if (idx == nums.length) return 0;
    //     Long key = ((long)prev << 16) | idx;
    //     Integer val = cache.get(key);
    //     if (val != null) return val;
    //     int len = dfs(nums, idx + 1, prev);
    //     if (nums[idx] > prev) {
    //         len = Math.max(len, dfs(
    //             nums, idx + 1, nums[idx]) + 1);
    //     }
    //     cache.put(key, len);
    //     return len;
    // }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
        // return dfs(nums, 0, Integer.MIN_VALUE);
    }
}
