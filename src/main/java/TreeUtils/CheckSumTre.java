package TreeUtils;
//A SumTree is a Binary Tree where the value of a node is
// equal to sum of the nodes present in its left subtree
// and right subtree.
public class CheckSumTre {
Node root;
  public static void main(String[] args) {
    CheckSumTre tree = new CheckSumTre();
    tree.root = new Node(26);
    tree.root.left = new Node(10);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(6);
    tree.root.right.right = new Node(3);

    if (tree.isSumTree(tree.root))
      System.out.println("The given tree is a sum tree");
    else
      System.out.println("The given tree is not a sum tree");
  }

  public boolean isSumTree(Node root){
    Count count = new Count();
    return isSumTree(root,count);
  }

  private boolean isSumTree(Node root,Count count){
    if(root == null){
      return true;
    }
    if(root.left == null && root.right == null){
      count.size = root.data;
      return true;
    }
    Count leftCount = new Count();
    Count rightCount = new Count();
    boolean isLeft = isSumTree(root.left,leftCount);
    boolean isRight = isSumTree(root.right,rightCount);
    count.size = root.data + leftCount.size + rightCount.size;
    return isLeft && isRight && root.data == (leftCount.size + rightCount.size);
  }
}
class Count{
  int size;
}
