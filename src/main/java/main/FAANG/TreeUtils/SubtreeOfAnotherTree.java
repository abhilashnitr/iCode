package main.FAANG.TreeUtils;

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        return serialize(s).contains(serialize(t)); // Java uses a naive contains algorithm so to ensure linear time,
        // replace with KMP algorithm
    }

    public String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        serialize(root, res);
        return res.toString();
    }

    private void serialize(TreeNode cur, StringBuilder res) {
        if (cur == null) {res.append(",#"); return;}
        res.append("," + cur.val);
        serialize(cur.left, res);
        serialize(cur.right, res);
    }


    //Java Concise O(n+m) Time O(n+m) Space
}
