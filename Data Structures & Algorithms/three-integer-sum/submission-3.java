class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
    
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            if (prev == nums[i]) continue;
            int target = -nums[i];
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = nums[leftIdx] + nums[rightIdx];
                if (sum > target) rightIdx--;
                else if (sum < target) leftIdx++;
                else {
                    res.add(List.of(-target, nums[leftIdx], nums[rightIdx]));
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
