class Solution {

    private static void backTrack(int[] nums, int idx, int target, List<List<Integer>> res, List<Integer> prev) {
        if (idx == nums.length) return;

        int currTarget = target - nums[idx];
        if (currTarget > 0) {
            prev.add(nums[idx]);
            backTrack(nums, idx, currTarget, res, prev);
            prev.remove(prev.size() - 1);
        } else if (currTarget == 0) {
            prev.add(nums[idx]);
            res.add(new ArrayList<>(prev));
            prev.remove(prev.size() - 1);
        }
        backTrack(nums, idx + 1, target, res, prev);    
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, target, res, new ArrayList<>());

        return res;
    }
}
