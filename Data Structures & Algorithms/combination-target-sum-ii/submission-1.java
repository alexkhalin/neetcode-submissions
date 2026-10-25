class Solution {

    private static void backTrack(int[] candidates, int target, int idx, List<List<Integer>> res, List<Integer> curr) {
        if (idx == candidates.length) return;

        int currTarget = target - candidates[idx];
        if (currTarget > 0) {
            curr.add(candidates[idx]);
            backTrack(candidates, currTarget, idx + 1, res, curr);
            curr.remove(curr.size() - 1);
        } else if (currTarget == 0) {
            curr.add(candidates[idx]);
            res.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
        }
        while (++idx < candidates.length && candidates[idx] == candidates[idx -1]);
        backTrack(candidates, target, idx, res, curr);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
}
