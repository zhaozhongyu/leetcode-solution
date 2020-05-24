package leetcode.tree;

import java.util.HashMap;
import java.util.HashSet;

public class problem653 {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        order(root, map);
        Object[] nums = map.keySet().toArray();
        for (int i = 0; i < nums.length; i++) {
            Integer n = (Integer) nums[i];
            if ((k - n != n && map.containsKey(k-n)) || (map.getOrDefault(k-n, 0) > 1)) {
                return true;
            }
        }
        return false;
    }

    public void order (TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return ;
        map.put(node.val, map.getOrDefault(node.val,0));
        order(node.left, map);
        order(node.right, map);
    }

    public static void main(String[] args ){
        Integer[] nums = new Integer[]{2, null,3};
        TreeNode node = TreeNode.createTreeNode(nums);
        new problem653().findTarget(node, 6);
    }
}
