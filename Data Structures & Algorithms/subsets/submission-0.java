class Solution {

    private void dfs(int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) return;
        List<Integer> prev = res.get(res.size() - 1);
        for (int i = idx; i != nums.length; i++) {
            List<Integer> curr = new ArrayList<>(prev);
            curr.add(nums[i]);
            res.add(curr);
            dfs(nums, i + 1, res);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        dfs(nums, 0, res);
        return res;    
    }
}
