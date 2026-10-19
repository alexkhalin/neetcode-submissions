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

    private int countGood(TreeNode root, Integer max) {
        if (root == null) return 0;

        int good = max > root.val ? 0 : 1;
        max = Math.max(max, root.val);

        return good + countGood(root.left, max) + countGood(root.right, max);
    }
    public int goodNodes(TreeNode root) {
        return countGood(root, Integer.MIN_VALUE);
    }
}
