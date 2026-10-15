class Solution {
    private int findMin(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (right != left) {
            int middle = (right + left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return right;        
    }
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = findMin(nums);
        int right = len + left - 1;
        while (left != right) {
            int middle = (left + right) / 2;
            if (target > nums[middle % len]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return nums[left % len] == target ? left % len : -1;
    }
}
