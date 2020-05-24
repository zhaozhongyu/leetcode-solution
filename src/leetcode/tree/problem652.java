package leetcode.tree;

import java.util.*;

public class problem652 {

    /**
     * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
     *
     * 两棵树重复是指它们具有相同的结构以及相同的结点值。
     * */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        if (root == null) return new ArrayList<>();
        List<TreeNode> list = new ArrayList<>();
        HashMap<Integer, List<TreeNode>> map = new HashMap<>(); // 用来记录值
        HashSet<TreeNode> allSameNode = new HashSet<>();
        getHeight(root, map);
        map.forEach((k,v) -> {
            for (int i = 0; i < v.size(); i++) {
                for (int j = i+1; j < v.size(); j++) {
                    if (!allSameNode.contains(v.get(i)) && !allSameNode.contains(v.get(j))) {
                        if (isSametree(v.get(i), v.get(j))) {
                            boolean hasSame = false;
                            for (int n = 0; n < list.size(); n ++) {
                                if (isSametree(list.get(n), v.get(i))) {
                                    hasSame = true;
                                    break;
                                }
                            }
                            if (!hasSame) {
                                list.add(v.get(i));
                            }
                            allSameNode.add(v.get(i));
                            allSameNode.add(v.get(j));
                        }
                    }
                }
            }
        });
        return list;
    }

    public int getHeight (TreeNode node, HashMap<Integer, List<TreeNode>> map) {
        if (node == null) return 0;
        int result = 0;
        if (node.left == null && node.right == null ) result = 1;
        else result = Math.max(getHeight(node.left, map), getHeight(node.right, map)) + 1;
        if (!map.containsKey(result)) {
            List<TreeNode> list = new ArrayList<>();
            list.add(node);
            map.put(result, list);
        } else {
            List<TreeNode> list = map.get(result);
            list.add(node);
        }
        return result;
    }

    public boolean isSametree (TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
    }


}
