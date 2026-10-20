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

    // preorder = {3, 1, 0, 2, 6, 4, 5, 8, 7, 10, 9}
    // inorder =  {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
    // preorderIdx: 11
    // inorderIdx: 9
    // stack: 10 9
    // parent: 8
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int preorderIdx = 1;
        int inorderIdx = 0;
        while (preorderIdx < preorder.length) {
            TreeNode parent = stack.peek();
            if (parent.val != inorder[inorderIdx]) {
                TreeNode left = new TreeNode(preorder[preorderIdx]);
                parent.left = left;
                stack.push(left);
                preorderIdx++;
            } else {
                stack.pop();
                inorderIdx++;
                if (stack.isEmpty() || stack.peek().val != inorder[inorderIdx]) {
                    TreeNode right = new TreeNode(preorder[preorderIdx]);
                    parent.right = right;
                    stack.push(right);
                    preorderIdx++;
                }
            }
            
        }

        return root;
    }
}
