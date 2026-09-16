class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best = nums[0];
        int len = nums.length;
        for (int start = 0; start < len; start++) {
            int curr = nums[start];        
            best = Math.max(best, curr);
            for (int i = 1; i < len; i++) {
                int idx = start + i;
                int n = nums[idx < len ? idx : idx - len];    
                if (n >= curr + n) {                
                    start += i - 1;
                    break;
                } 
                curr += n;
                if (best < curr) best = curr;
                best = Math.max(best, curr);                
            }        
        }

        return best;
    }
}