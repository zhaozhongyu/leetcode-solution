package leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> nodesums = new Stack<>();
        Stack<List<Integer>> paths = new Stack<>();
        stack.push(root);
        nodesums.push(0);
        List<Integer> list = new ArrayList<>();
        paths.push(list);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int nodesum = nodesums.pop() + node.val;
            list = paths.pop();
            list.add(node.val);
            if (node.left == null && node.right == null) {
                if (nodesum == sum) {
                    result.add(list);
                }
                continue;
            }
            if (node.left != null) {
                stack.push(node.left);
                nodesums.push(nodesum);
                paths.push(new ArrayList<>(list));
            }
            if (node.right != null) {
                stack.push(node.right);
                nodesums.push(nodesum);
                paths.push(new ArrayList<>(list));
            }
        }
        return result;
    }
}
