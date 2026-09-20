class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
    
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (prev == nums[i]) continue;
            int first = nums[i];
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = first + nums[leftIdx] + nums[rightIdx];
                if (sum > 0) {
                    rightIdx = Arrays.binarySearch(nums, leftIdx + 1, rightIdx, -first - nums[leftIdx]);
                    if (rightIdx < 0) rightIdx = -rightIdx - 2;
                }
                else if (sum < 0) leftIdx++;
                else {
                    res.add(List.of(first, nums[leftIdx], nums[rightIdx]));
                    do {
                        leftIdx++;
                    } while (leftIdx < rightIdx && nums[leftIdx] == nums[leftIdx - 1]);
                    do {
                        rightIdx--;
                    } while (leftIdx < rightIdx && nums[rightIdx] == nums[rightIdx + 1]);
                }
            }
            prev = nums[i];
        }
        return res;
        
    }
}
