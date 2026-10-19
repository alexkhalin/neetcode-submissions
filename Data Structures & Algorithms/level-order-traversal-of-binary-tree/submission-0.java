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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        List<TreeNode> currLayer = new ArrayList<>();
        if (root != null) currLayer.add(root);
        while (!currLayer.isEmpty()) {
            List<Integer> resLayer = new ArrayList<>();
            List<TreeNode> nextLayer = new ArrayList<>();
            for (TreeNode node : currLayer) {
                resLayer.add(node.val);
                if (node.left != null) nextLayer.add(node.left);
                if (node.right != null) nextLayer.add(node.right);
            }
            res.add(resLayer);
            currLayer = nextLayer;
        }

        return res;
    }
}
