class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len > 2) nums[2] += nums[0];
        for (int i = 3; i < len; i++) {
            nums[i] += Math.max(nums[i - 2], nums[i - 3]);
        }
        return Math.max(nums[len - 1], nums[len - 2]);
    }
}
