package LeetCode.Easy.April27;

public class SameTree {
  public boolean isSameTree(TreeNode p, TreeNode q) {

    if(p==null&&q==null)
      return true;
    if(p==null||q==null)
      return false;
    return (p.val==q.val)&&isSameTree(p.left,q.left)&&
        isSameTree(p.right,q.right);
  }
  public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
  }
}
