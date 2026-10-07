class Solution {
    private static void calc(int[] nums, int step) {
        int last = nums.length - step;
        for (int i = 0; i < last; i++) {
            nums[i] = Math.max(nums[i], nums[i + step]);
        }
    }

    private static void merge(int[] nums, int[] res, int shift) {
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(res[i], nums[i + shift]);
        }
    } 

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        Arrays.fill(res, Integer.MIN_VALUE);
    
        int step = 1;
        int shift = 0;
        for (; ;) {
            if ((k & 1) != 0) {
                merge(nums, res, shift);
                shift += step;
            }
            k >>>= 1;
            if (k == 0) break;
            
            calc(nums, step);
            step <<= 1;
        }

        return res;
    }
}
