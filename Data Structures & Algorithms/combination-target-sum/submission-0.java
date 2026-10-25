class Solution {

    private static void backTrack(int[] nums, int idx, int target, List<List<Integer>> res, List<Integer> prev, int prevSum) {
        if (idx == nums.length) return;

        for (int i = idx; i < nums.length; i++) {
            int currSum = prevSum + nums[i];
            if (currSum < target) {
                prev.add(nums[i]);
                backTrack(nums, i, target, res, prev, currSum);
                prev.remove(prev.size() - 1);
            } else if (currSum == target) {
                prev.add(nums[i]);
                res.add(new ArrayList<>(prev));
                prev.remove(prev.size() - 1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, target, res, new ArrayList<>(), 0);

        return res;
    }
}
