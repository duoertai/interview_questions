package interview.pinterest.phone.DeleteNodeInBST;

import interview.TreeNode;

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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;

        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if(key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null && root.right == null) {
                root = null;
            } else if(root.left != null) {
                TreeNode p = root.left;
                while(p.right != null)
                    p = p.right;

                root.val = p.val;
                root.left = deleteNode(root.left, p.val);
            } else {
                TreeNode p = root.right;
                while(p.left != null)
                    p = p.left;

                root.val = p.val;
                root.right = deleteNode(root.right, p.val);
            }
        }

        return root;
    }
}
