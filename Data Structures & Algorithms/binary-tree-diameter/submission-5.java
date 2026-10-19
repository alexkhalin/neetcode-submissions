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
    private int[] getLongest(TreeNode root) {
        
        if (root == null) return new int[] {0, 0};

        
        int[] left = getLongest(root.left);
        int[] right = getLongest(root.right);

        int longestInNode = left[0] + right[0];
        left[0] = Math.max(left[0], right[0]) + 1;
        left[1] = Math.max(right[1], Math.max(left[1], longestInNode));
        return left;
    } 
    public int diameterOfBinaryTree(TreeNode root) {
        return getLongest(root)[1];
    }
}
