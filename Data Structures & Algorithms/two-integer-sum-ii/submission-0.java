class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftIdx = 0;
        int rightIdx = numbers.length - 1;
        while (leftIdx < rightIdx) {
            int current = numbers[leftIdx] + numbers[rightIdx];
            if (current < target) leftIdx++;
            else if (current > target) rightIdx--;
            else return new int[]{++leftIdx, ++rightIdx};
        }
        return null;
    }
}
