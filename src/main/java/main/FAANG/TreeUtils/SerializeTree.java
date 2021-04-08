package main.FAANG.TreeUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeTree {

    private static final String spliter = ",";
    private static final String NN = "#";

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        SerializeTree st=new SerializeTree();
        String decod = st.serialize(root);
        System.out.println(decod);

        Node res=st.deserialize(decod);

        preOrderTraversal(res);
    }

    public static void preOrderTraversal(Node root) {
        Stack<Node> st=new Stack<>();
        st.push(root);
        System.out.print("PreOrder :");
        while(!st.empty()){
            System.out.print(st.peek().data+" ");
            Node data=st.pop();
            if(data.right!=null)
                st.push(data.right);
            if(data.left!=null)
                st.push(data.left);
        }
        System.out.println();
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(Node node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(node.data).append(spliter);
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

//    public String serialize(Node root) {
//        if (root == null) return "#";
//        return root.data + "," + serialize(root.left) + "," + serialize(root.right);
//    }

    public Node deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private Node helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        Node root = new Node(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
