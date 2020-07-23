package interview.amazon.RecoverBinarySearchTree;

import interview.TreeNode;

import java.util.*;

class Solution {
    public void recoverTree(TreeNode root) {
        if(root == null)
            return;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }

        TreeNode x = null;
        TreeNode y = null;

        TreeNode prev = null;
        TreeNode curr = null;

        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            if(temp.right != null) {
                p = temp.right;
                while(p != null) {
                    stack.push(p);
                    p = p.left;
                }
            }

            if(curr == null) {
                curr = temp;
            } else {
                prev = curr;
                curr = temp;

                if(prev.val > curr.val) {
                    y = curr;
                    if(x == null)
                        x = prev;
                    else
                        break;
                }
            }
        }

        int temp = x.val;
        x.val = y.val;
        y.val = temp;

    }
}
