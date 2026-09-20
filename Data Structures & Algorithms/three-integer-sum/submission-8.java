class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res = new ArrayList<>();
        
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length - 2 && nums[i] <= 0; i++) {
            int first = nums[i];
            if (prev == first) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = first + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(List.of(first, nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            prev = first;
        }
        
        return res;
        
    }
}
