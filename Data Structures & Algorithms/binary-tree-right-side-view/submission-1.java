/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private void fillView(TreeNode root, List<Integer> view, int level) {
        if (root == null) return;

        if (view.size() == level) view.add(root.val);

        level++;
        fillView(root.right, view, level);
        fillView(root.left, view, level);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        fillView(root, res, 0);
        return res;
    }
}
