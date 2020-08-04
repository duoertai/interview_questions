package interview.apple.LowestCommonAncestorOfABinaryTree;

import interview.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(p == root)
            return p;
        if(q == root)
            return q;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null && right == null)
            return null;
        if(left != null && right == null)
            return left;
        if(left == null && right != null)
            return right;
        if(left != null && right != null)
            return root;

        return null;
    }
}
