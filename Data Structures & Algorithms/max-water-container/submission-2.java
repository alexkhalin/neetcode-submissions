class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0; 
        int right = heights.length - 1;
        int heighestLeft = heights[left];
        int heighestRight = heights[right];
        int best = 0;
        while (left < right) {
            int width = right - left;
            int vol = width * Math.min(heights[left], heights[right]);
            best = Math.max(best, vol);
        
            if (heighestLeft < heighestRight) {
                left++;
                heighestLeft = Math.max(heighestLeft, heights[left]);
            } else {
                right--;
                heighestRight = Math.max(heighestRight, heights[right]);
            }
        }

        return best;
    }
}
