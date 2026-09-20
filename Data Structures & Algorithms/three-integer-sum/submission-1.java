class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();
    
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            int leftIdx = i + 1;
            int rightIdx = nums.length - 1;

            while (leftIdx < rightIdx) {
                int sum = nums[leftIdx] + nums[rightIdx];
                if (sum > target) rightIdx--;
                else if (sum < target) leftIdx++;
                else {
                    res.add(List.of(-target, nums[leftIdx], nums[rightIdx]));
                    leftIdx++;
                    rightIdx--;
                }
            }

        }
        return new ArrayList<>(res);
        
    }
}
