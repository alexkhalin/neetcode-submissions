class Solution {
    public int findMin(int[] nums) {

        int right = nums.length - 1;
        int left = 0;
        while (right != left) {
            int i = (right + left) / 2;
            if (nums[i] > nums[right]) {
                left = i + 1;
            } else {
                right = i;
            }
        }

        return nums[right];        
    }
}
