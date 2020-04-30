package leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem95 {
    /*
    * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。

        示例:

        输入: 3
        输出:
        [
          [1,null,3,2],
          [3,2,null,1],
          [3,1,null,null,2],
          [2,1,3],
          [1,null,2,null,3]
        ]
        解释:
        以上的输出对应以下 5 种不同结构的二叉搜索树：

           1         3     3      2      1
            \       /     /      / \      \
             3     2     1      1   3      2
            /     /       \                 \
           2     1         2                 3
    * */

    // 递归法
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (n == 0) return treeNodes;
        return recursion(1, n);
    }

    public List<TreeNode> recursion (int start, int end) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }
        if (start == end) {
            result.add(new TreeNode(start));
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = recursion(start, i-1);
            List<TreeNode> rightNodes = recursion(i+1, end);
            for(TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode: rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    result.add(root);
                }
            }
        }

        return result;
    }

    // 回溯法解决
    public List<TreeNode> generateTrees1(int n) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (n == 0) return treeNodes;
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> track = new LinkedList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        backtrack(nums, track, lists);
        TreeNode root = null;
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> list = lists.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (root == null) {
                    root = new TreeNode(list.get(j));
                    continue;
                }
                if (!insert(root, list.get(j))) {
                    root = null;
                    break;
                }
            }
            if (root != null) {
                treeNodes.add(root);
            }
            root = null;
        }
        return treeNodes;
    }


    public void backtrack(int[] nums, List<Integer> track, List<List<Integer>> lists) {
        if (track.size() == nums.length) {
            lists.add(new LinkedList<>(track));
            return ;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            backtrack(nums, track, lists);
            track.remove(track.size()-1);
        }
    }

    public boolean insert(TreeNode root, int num) {
        if (root == null) {
            return false;
        }
        if (num < root.val ) {
            if (root.right != null) { // 此时不合法
                return false;
            }
            if (root.left != null) {
                return insert(root.left, num);
            } else {
                root.left = new TreeNode(num);
            }
        } else {
            if (root.right != null) {
                return insert(root.right, num);
            } else {
                root.right = new TreeNode(num);
            }
        }
        return true;
    }
}
