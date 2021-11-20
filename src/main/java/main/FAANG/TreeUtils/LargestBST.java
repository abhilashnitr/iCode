package main.FAANG.TreeUtils;

//Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with
// largest number of nodes in it.
public class LargestBST {


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right.right = new Node(7);
        LargestBST largestBST=new LargestBST();
        System.out.println(largestBST.largestBST(root));
    }
    public int largestBST(Node root){
        int[] res=largestBSTUtils(root);
        return res[2];
    }

    private int[] largestBSTUtils(Node root) {
        if(root==null){
            return new int[]{Integer.MAX_VALUE,Integer.MIN_VALUE,0};
        }
        int[] leftRes=largestBSTUtils(root.left);
        int[] rightRes=largestBSTUtils(root.right);

        if(root.data>leftRes[1]&&root.data<rightRes[0]){
            return  new int[]{Math.min(root.data,leftRes[0]),Math.max(rightRes[1], root.data),leftRes[2]+rightRes[2]+1};
        }else {
            return new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(leftRes[2],rightRes[2])};
        }
    }


    private class State {
        public boolean isBST;
        public int min;
        public int max;
        public int num;
        public State(boolean isBST, int min, int max, int num) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.num = num;
        }
    }
    private int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        max = 0;
        lbst(root);
        return max;
    }
    private State lbst(TreeNode node) {
        State result = null;
        if (node == null) {
            return result;
        }
        State left = lbst(node.left);
        State right = lbst(node.right);
        if ((left == null || (left.isBST && node.val > left.max))
                && (right == null || (right.isBST && node.val < right.min))) {
            //A valid BST
            int newMin = left == null?node.val:left.min;
            int newMax = right == null?node.val:right.max;
            int newNum = (left == null?0:left.num) + (right == null?0:right.num) + 1;
            max = Math.max(max, newNum);
            return new State(true, newMin, newMax, newNum);
        }
        return new State(false, 0, 0, 0);
    }
}
