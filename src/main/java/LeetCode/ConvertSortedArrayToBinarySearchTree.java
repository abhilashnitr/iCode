package LeetCode;


public class ConvertSortedArrayToBinarySearchTree {

  public TreeNode sortedArrayToBST(int[] nums) {
    return helper(nums, 0, nums.length - 1);

  }
  private  TreeNode helper(int[] nums, int low, int high) {
    if(low > high) {
      return null;
    }
    int mid = low + (high - low)/2;
    TreeNode head = new TreeNode(nums[mid]);
    head.left = helper(nums, low, mid - 1);
    head.right = helper(nums, mid + 1, high);
    return head;
  }
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }


}


