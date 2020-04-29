package TreeUtils;

import java.util.Stack;

//https://medium.com/@fabianterh/iteratively-solving-flatten-binary-tree-to-linked-list-in-place-50ac7825f75b
//https://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
public class FlattenABinarytree {

  private Node curr;
  public void flatten(Node root) {
    if (root == null) {
      return;
    } else {
      curr = root;
    }
    helper(root);
  }

  private void helper(Node root) {
    if (root == null) return;
    Node l = root.left;
    Node r = root.right;
    root.left = null;
    root.right =  null;
    if (curr != root) {
      curr.right = root;
      curr = root;
    }
    helper(l);
    helper(r);
  }

  public void flatten2(Node root) {
    if (root == null) return;

    helper2(root, null);
  }

  private Node helper2(Node root, Node last) {
    if (root == null) return last;
    if (last != null) last.right = root;

    Node l = root.left;
    Node r = root.right;
    root.left = null;
    root.right = null;
    Node newLast = helper2(l, root);
    return helper2(r, newLast);
  }
  public void flattenItrative(Node root) {
    Stack<Node> stack = new Stack<Node>();
    Node p = root;
    while(p != null || !stack.empty()){
      if(p.right != null){
        stack.push(p.right);
      }
      if(p.left != null){
        p.right = p.left;
        p.left = null;
      }else if(!stack.empty()){
        Node temp = stack.pop();
        p.right=temp;
      }

      p = p.right;
    }
  }
}
