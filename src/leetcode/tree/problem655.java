package leetcode.tree;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.LinkedList;
import java.util.List;

public class problem655 {
    /**
     * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
     *
     * 行数 m 应当等于给定二叉树的高度。
     * 列数 n 应当总是奇数。
     * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
     * 每个未使用的空间应包含一个空的字符串""。
     * 使用相同的规则输出子树。
     * */
    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        return printTree(root, height);
    }

    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public List<List<String>> printTree(TreeNode node, int height) {
        List<List<String>> lists = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i < Math.pow(2, height-1); i++) {
            list.add("");
        }
        if (node == null) {
            list.add("");
        } else {
            list.add(String.valueOf(node.val));
        }
        for (int i = 1; i < Math.pow(2, height-1); i++) {
            list.add("");
        }
        lists.add(list);
        if (height > 1) {
            List<List<String>> leftLists = null;
            List<List<String>> rightLists = null;
            if (node != null) {
                leftLists = printTree(node.left, height-1);
                rightLists = printTree(node.right, height-1);
            } else {
                leftLists = printTree(null, height-1);
                rightLists = printTree(null, height-1);
            }
            for (int i = 0; i < leftLists.size(); i++) {
                List<String> left = leftLists.get(i);
                List<String> right = rightLists.get(i);
                left.add("");
                left.addAll(right);
                lists.add(left);
            }
        }
        return lists;
    }
}
