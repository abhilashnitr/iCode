package main.FAANG.TreeUtils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {


    public static void main(String[] args) {
        FindDuplicateSubtrees subtrees=new FindDuplicateSubtrees();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.right.left=new TreeNode(2);
        root.right.right=new TreeNode(4);
        root.right.left.left=new TreeNode(4);



        System.out.println(subtrees.findDuplicateSubtrees(root));
        System.out.println(subtrees.findDuplicateSubtreesV2(root));

    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new LinkedList<>();
        postorder(root, new HashMap<>(), res);
        return res;
    }

    public String postorder(TreeNode cur, Map<String, Integer> map, List<TreeNode> res) {
        if (cur == null) return "#";
        String serial = cur.val + "," + postorder(cur.left, map, res) + "," + postorder(cur.right, map, res);
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        if (map.get(serial) == 2) res.add(cur);
        return serial;
    }

    int curId = 1;

    public List<TreeNode> findDuplicateSubtreesV2(TreeNode root) {
        Map<String, Integer> serialToId = new HashMap<>();
        Map<Integer, Integer> idToCount = new HashMap<>();
        List<TreeNode> res = new LinkedList<>();
        postorder(root, serialToId, idToCount, res);
        return res;
    }

    private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
        if (root == null) return 0;
        int leftId = postorder(root.left, serialToId, idToCount, res);
        int rightId = postorder(root.right, serialToId, idToCount, res);
        String curSerial = leftId + "," + root.val + "," + rightId;
        int serialId = serialToId.getOrDefault(curSerial, curId);
        if (serialId == curId) curId++;
        serialToId.put(curSerial, serialId);
        idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
        if (idToCount.get(serialId) == 2) res.add(root);
        return serialId;
    }
    /*
             1
            / \
           2   3
          /   / \
         4   2   4
            /
           4

    Method 1:
    4,#,# -> 3
    2,4,#,#,# -> 2
    3,2,4,#,#,#,4,#,# ->  1
    1,2,4,#,#,#,3,2,4,#,#,#,4,#,# -> 1


    SerialTOId
    0,4,0 ->  1
    1,2,0 ->  2
    2,3,1 ->  3
    2,1,3 ->  4

    idToCount:
    1->3
    2->2
    3->1
    4->1

    */
}
