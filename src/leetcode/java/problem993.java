package leetcode.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem993 {
    // 这是二叉树, 但不是二叉搜索树
    public boolean isCousins(TreeNode root, int x, int y) {
        LinkedList<TreeNode> list = new LinkedList<>();
        LinkedList<Integer> levelList = new LinkedList<>();
        if (root.val == x || root.val == y) {
            return false;
        }
        list.add(root);
        levelList.add(0);
        int xLevel = -1, yLevel = -1, curLevel = -1;
        while (list.size() != 0) {
            if (curLevel != -1 && levelList.peek() != curLevel) { // 这里说明不同级
                return false;
            }
            root = list.pop();
            if ((root.left != null && root.right != null) && ((root.left.val == x && root.right.val == y) || (root.left.val == y && root.right.val == x))) {
                return false;
            }
            int level = levelList.pop();
            if (root.left != null) {
                if (root.left.val == x || root.left.val == y) {
                    if (curLevel != -1 && curLevel == level) {
                        return true;
                    }
                    if (curLevel == -1) {
                        curLevel = level;
                    }
                } else {
                    list.addLast(root.left);
                    levelList.addLast(level + 1);
                }
            }
            if (root.right != null) {
                if (root.right.val == x || root.right.val == y) {
                    if (curLevel != -1 && curLevel == level) {
                        return true;
                    }
                    if (curLevel == -1) {
                        curLevel = level;
                    }
                } else {
                    list.addLast(root.right);
                    levelList.addLast(level + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.createTreeNode(new Integer[]{1,2,4,3,8,6,5,null,7});
        new problem993().isCousins(node, 5, 8);
    }
}
