class Solution {
    public int maxProduct(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int forward = 1;
        int backward = 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            forward *= nums[i];
            backward *= nums[j];
            max = Math.max(max, Math.max(forward, backward));
            if (forward == 0) forward = 1;
            if (backward == 0) backward = 1;
        }

        return max;
    }
}
