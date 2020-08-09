package interview.pinterest.phone.SerializeAndDeserializeNaryTree;

import java.util.*;

class Codec {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public String serialize(Node root) {
        if(root == null)
            return "";

        return buildString(root);
    }

    private String buildString(Node root) {
        StringBuilder sb = new StringBuilder("" + root.val);
        if(root.children != null && root.children.size() != 0) {
            sb.append("[");

            for(Node c: root.children) {
                sb.append(buildString(c)).append(",");
            }

            sb.setLength(sb.length() - 1);

            sb.append("]");
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if(data.length() == 0)
            return null;

        if(data.indexOf("[") == -1)
            return new Node(Integer.parseInt(data), new ArrayList<>());

        int start = data.indexOf("[");
        Node root = new Node(Integer.parseInt(data.substring(0, start)), new ArrayList<>());
        buildNode(data.substring(start + 1, data.length() - 1), root);

        return root;
    }

    private void buildNode(String data, Node root) {
        int num = 0;
        int i = 0;
        while(i < data.length()) {
            if(data.charAt(i) >= '0' && data.charAt(i) <= '9') {

                while(i < data.length() && data.charAt(i) >= '0' && data.charAt(i) <= '9') {
                    num = num * 10 + (int) (data.charAt(i) - '0');
                    i++;
                }
                root.children.add(new Node(num, new ArrayList<>()));
                num = 0;
            } else if(data.charAt(i) == ','){
                i++;
            } else if(data.charAt(i) == '[') {
                int count = 1;
                int j = i + 1;
                while(j < data.length() && count != 0) {
                    if(data.charAt(j) == '[')
                        count++;
                    else if(data.charAt(j) == ']')
                        count--;
                    j++;
                }
                j--;
                String s = data.substring(i + 1, j);
                buildNode(s, root.children.get(root.children.size() - 1));
                i = j + 1;
            }
        }
    }

    public static void main(String[] args) {
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));