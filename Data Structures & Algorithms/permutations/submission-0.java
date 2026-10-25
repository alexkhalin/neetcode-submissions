class Solution {

    private static void backTrack(int[] nums, int flags, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((flags & (1 << i)) == 0) {
                curr.add(nums[i]);
                backTrack(nums, flags | (1 << i), res, curr);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        backTrack(nums, 0, res, new ArrayList<>());
        return res;
    }
}
