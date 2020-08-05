package interview.apple.BoundaryOfBinaryTree;

import interview.TreeNode;

import java.util.*;

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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        // root
        res.add(root.val);

        // left boundary
        if(root.left != null) {
            TreeNode p = root.left;
            while(!isLeaf(p)) {
                res.add(p.val);
                if(p.left != null)
                    p = p.left;
                else if(p.right != null)
                    p = p.right;
            }
        }

        // leaves
        addLeaves(res, root.left);
        addLeaves(res, root.right);

        // right boundary
        if(root.right != null) {
            Stack<Integer> stack = new Stack<>();
            TreeNode p = root.right;
            while(!isLeaf(p)) {
                stack.push(p.val);
                if(p.right != null)
                    p = p.right;
                else if(p.left != null)
                    p = p.left;
            }

            while(stack.size() > 0)
                res.add(stack.pop());
        }

        return res;
    }

    private void addLeaves(List<Integer> res, TreeNode root) {
        if(root == null)
            return;

        if(isLeaf(root)) {
            res.add(root.val);
            return;
        }

        addLeaves(res, root.left);
        addLeaves(res, root.right);
    }

    private boolean isLeaf(TreeNode p) {
        if(p == null)
            return false;
        return p.left == null && p.right == null;
    }
}
