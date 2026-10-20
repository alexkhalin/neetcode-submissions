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
    private int[] calcPathSum(TreeNode root) {
        if (root == null) return new int[] {0, Integer.MIN_VALUE};

        int[] left = calcPathSum(root.left);
        int[] right = calcPathSum(root.right);

        int maxBranch = Math.max(Math.max(left[0], right[0]) + root.val, root.val);
        left[1] = Math.max(Math.max(maxBranch, left[1]), Math.max(right[1], left[0] + right[0] + root.val));
        left[0] = maxBranch;
        
        return left; 
    }

    public int maxPathSum(TreeNode root) {
        return calcPathSum(root)[1];
    }
}
