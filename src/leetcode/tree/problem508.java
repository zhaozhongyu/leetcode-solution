package leetcode.tree;

import java.util.*;

public class problem508 {
    /**
     * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
     *
     * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
     *
     *  
     *
     * 示例 1：
     * 输入:
     *
     *   5
     *  /  \
     * 2   -3
     * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
     *
     * 示例 2：
     * 输入：
     *
     *   5
     *  /  \
     * 2   -5
     * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/most-frequent-subtree-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int maxCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int sumNode = sum(node);
            int count = map.getOrDefault(sumNode, 0) + 1;
            map.put(sumNode, count);
            maxCount = Math.max(maxCount, count);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        int finalMaxCount = maxCount;
        map.forEach((k, v) -> {
            if (v == finalMaxCount) {
                list.add(k);
            }
        });
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int sum(TreeNode node) {
        if (node == null) return 0;
        int result = node.val;
        result += sum(node.left) + sum(node.right);
        return result;
    }

}
