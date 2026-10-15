class Solution {
    public int findMin(int[] nums) {

        int right = nums.length;
        if (nums[0] <= nums[right - 1]) return nums[0];

        int left = 0;
        while (right - left > 1) {
            int i = (right + left) / 2;
            if (nums[i] > nums[left]) {
                left = i;
            } else {
                right = i;
            }
        }

        return nums[right];
    }
}
