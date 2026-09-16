class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best = Integer.MIN_VALUE;
        int worst = Integer.MAX_VALUE;
        int total = 0;
        int currMax = 0;
        int currMin = 0;
        for (int n :nums) {
            total += n;
            currMax = Math.max(currMax + n, n);
            currMin = Math.min(currMin + n, n);
            best = Math.max(best, currMax);
            worst = Math.min(worst, currMin);
        }

        return best < 0 ? best : Math.max(best, total - worst);
    }
}