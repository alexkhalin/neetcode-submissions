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
    private int getDepth(TreeNode root) {
        if (root == null) return 0;

        int left = getDepth(root.left);
        if (left == -1) return -1;
        int right = getDepth(root.right);
        if (right == -1 || Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) != -1;
    }
}
