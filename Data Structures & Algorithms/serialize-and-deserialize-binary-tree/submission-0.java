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

public class Codec {

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        sb.append(':');
        serialize(root.left, sb);
        sb.append(':');
        serialize(root.right, sb);
        sb.append(';');
        
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    private static class DeserializationContext {
        char[] data;
        int index;
        DeserializationContext(String data) {
            this.data = data.toCharArray();
        }
    }

    private int parseSign(DeserializationContext ctx) {
        if (ctx.data[ctx.index] == '-') {
            ctx.index++;
            return -1;
        }
        // if (ctx.data[ctx.index] == '+') {
        //     ctx.index++;
        //     return 1;
        // }
        return 1;
    }

    private int deserializeNumber(DeserializationContext ctx) {
        int n = 0;
        int s = parseSign(ctx); 
        while (ctx.data[ctx.index]<='9') {
            n *= 10;
            n += ctx.data[ctx.index++] - '0';
        }
        return n * s;
    }

    private TreeNode deserializeNode(DeserializationContext ctx) {
        if (ctx.index >= ctx.data.length || ctx.data[ctx.index] > '9') return null;
        TreeNode node = new TreeNode();
        node.val = deserializeNumber(ctx);
        ctx.index++;
        node.left = deserializeNode(ctx);
        ctx.index++;
        node.right = deserializeNode(ctx);
        ctx.index++;
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeNode(new DeserializationContext(data));
    }
}
