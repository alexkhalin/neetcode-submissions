class Solution {

    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left != right) {
            int middle = (left + right) / 2;
            if (nums[left] > nums[middle]) {
                if (target < nums[left] && target > nums[middle]) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            } else {
                if (target <= nums[middle] && target >= nums[left]) {
                    right = middle;
                } else {
                    left = middle + 1;
                }
            }
        }
        return nums[left % len] == target ? left % len : -1;    }
}
