package interview.databricks.PrintTreeByColumn;

import java.util.*;

public class Solution {
    static class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public char c;

        public TreeNode(char c) {
            this.left = null;
            this.right = null;
            this.c = c;
        }
    }

    public static void printTreeByColumn(TreeNode root) {
        if (root == null)
            return;

        Map<Integer, List<String[]>> map = new TreeMap<>();
        traverseTree(root, map, "0");

        for (Integer p: map.keySet()) {
            List<String[]> list = map.get(p);
            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return o1[0].length() - o2[0].length();
                }
            });
            for(String[] strs: list) {
                System.out.print(strs[1]);
            }
            System.out.print(" ");
        }
    }

    private static void traverseTree(TreeNode root, Map<Integer, List<String[]>> map, String position) {
        if(root == null)
            return;

        int col = getColumnNum(position);
        if(!map.containsKey(col)){
            map.put(col, new ArrayList<>());
        }

        map.get(col).add(new String[] {position, "" + root.c});
        traverseTree(root.left, map, position + "0");
        traverseTree(root.right, map, position + "1");
    }

    private static int getColumnNum(String position) {
        int col = 0;
        for(int i = 1; i < position.length(); i++) {
            if(position.charAt(i) == '0')
                col--;
            else
                col++;
        }

        return col;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('c');
        root.right.left = new TreeNode('d');
        root.right.right = new TreeNode('e');
        root.right.left.left = new TreeNode('f');
        root.right.left.left.left = new TreeNode('g');

        printTreeByColumn(root);
    }
}
