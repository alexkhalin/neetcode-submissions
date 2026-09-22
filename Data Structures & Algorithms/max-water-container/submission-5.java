class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0; 
        int right = heights.length - 1;

        int best = 0;
        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(heights[left], heights[right]);
            int vol = width * minHeight;
            best = Math.max(best, vol);
        
            while (left < right && heights[left] <= minHeight) {
                left++;
            }
            while (left < right && heights[right] <= minHeight) {
                right--;
            }
        }

        return best;    
    }
}
