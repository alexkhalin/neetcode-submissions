class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];

        int prevPrev0 = 0, prevPrev1 = 0, prev0 = 0, prev1 = 0;
        for (int i = 1; i < len; i++) {
            int curr0 = Math.max(prevPrev0 + nums[i - 1], prev0);
            int curr1 = Math.max(prevPrev1 + nums[i], prev1);
            prevPrev0 = prev0;
            prevPrev1 = prev1;
            prev0 = curr0;
            prev1 = curr1;
        }
        return Math.max(prev0, prev1);
    }
}
