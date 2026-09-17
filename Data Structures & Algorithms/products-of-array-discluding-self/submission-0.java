class Solution {
    public int[] productExceptSelf(int[] nums) {
        final int len = nums.length;
        final int[] res = new int[len]; 
        int prod = 1;
        for (int i = 0; i < len; ++i) {
            res[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for (int i = len - 1; i >= 0; --i) {
            res[i] *= prod;
            prod *= nums[i];
        }

        return res;
    }
}  
