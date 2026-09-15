class Solution {
    public int maxSubArray(int[] nums) {
        int best = Integer.MIN_VALUE;
        int curr = 0;
        for (int n : nums) {
            curr = Math.max(curr + n, n);
            best = Math.max(best, curr);
        }
        return best;
    }
}
