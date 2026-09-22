class Solution {
    public int trap(int[] height) {
        int vol = 0;
        int len = height.length;
        int maxLevelLeft = height[0];
        int maxLevelRight = height[len - 1];
        int leftIdx = 1;
        int rightIdx = len - 2;
        while (leftIdx <= rightIdx) {
            if (maxLevelLeft < maxLevelRight) {
            if (maxLevelLeft > height[leftIdx]) {
                vol += maxLevelLeft - height[leftIdx];
            } else {
                maxLevelLeft = height[leftIdx];
            }
            leftIdx++;
            } else {
            if (maxLevelRight > height[rightIdx]) {
                vol += maxLevelRight - height[rightIdx];
            } else {
                maxLevelRight = height[rightIdx];
            }
            rightIdx--;
            }
        }
        return vol;        
    }
}
