class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int best = nums[0];               //15
        int len = nums.length;
        for (int start = 0; start < len; start++) { //6
            int curr = nums[start];                 //10
            best = Math.max(best, curr);
            for (int i = 1; i < len; i++) {         //4
                int n = nums[(start + i) % len];    //4
                if (n >= curr + n) {                
                    start += i - 1;
                    break;
                } 
                curr += n;
                best = Math.max(best, curr);                
            }        
        }

        return best;
    }
}