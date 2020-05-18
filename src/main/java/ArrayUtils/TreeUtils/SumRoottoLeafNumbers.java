package ArrayUtils.TreeUtils;

public class SumRoottoLeafNumbers {

  int sum=0;
  public void F(Node root,int num)
  {
    if(root==null) return;
    if(root.left==null && root.right==null)
    {
      int v=(((num)*10)+(root.data));
      sum=(sum+v);
      return;
    }
    int v=(((num)*10)+(root.data));
    F(root.left,v);
    F(root.right,v);
  }
  public int sumNumbers(Node root) {
    F(root,0);
    return sum;
  }

  public static void main(String[] args) {
    Node root = new Node(3);
    root.left = new Node(2);
    root.right = new Node(4);
    root.left.left = new Node(1);
    root.left.right = new Node(6);
    root.right.right = new Node(5);
    root.right.left = new Node(7);
    SumRoottoLeafNumbers s= new SumRoottoLeafNumbers();
    System.out.println(  s.sumNumbers(root));
  }

}
