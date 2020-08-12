package interview.pinterest.onsite.ClosestBinarySearchTreeValue;

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
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        double diff = Math.abs(root.val * 1.0 - target);
        TreeNode p = root;
        while(p != null) {
            if(Math.abs(p.val * 1.0 - target) < diff) {
                diff = Math.abs(p.val * 1.0 - target) ;
                res = p.val;
            }

            if(p.val < target)
                p = p.right;
            else if(p.val > target)
                p = p.left;
            else
                return p.val;
        }

        return res;
    }
}