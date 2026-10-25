class Solution {
    private static void backTrack(int[] nums, int idx, List<List<Integer>> res, List<Integer> prev) {
        if (idx == nums.length) return;

        prev.add(nums[idx]);
        res.add(new ArrayList(prev));
        backTrack(nums, idx + 1, res, prev);
        prev.removeLast();

        while (++idx != nums.length && nums[idx] == nums[idx - 1]);
        backTrack(nums, idx, res, prev);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(List.of());
        backTrack(nums, 0, res, new ArrayList<>());
        return res;
    }
}
