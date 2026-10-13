class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        int i = right / 2;
        while (right - left > 1) {
            int curr = nums[i];
            if (curr < target) {
                left = i;
            } else if (curr > target) {
                right = i;
            } else {
                return i;
            }
            i = (right + left) / 2;
        }
        return nums[i] == target ? i : -1;
    }
}
