package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class problem515 {

    public List<Integer> largestValues(TreeNode root) {
        LinkedList<TreeNode> nodes = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        int num = 1;
        int temp = 0;
        int max = root.val;
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pollFirst();
            num --;
            max = Math.max(node.val, max);
            if (node.left != null) {
                nodes.addLast(node.left);
                temp ++;
            }
            if (node.right != null) {
                nodes.addLast(node.right);
                temp++;
            }
            if (num == 0) { // 进入下一层
                num = temp;
                temp = 0;
                result.add(max); //第一个节点
                max = Integer.MIN_VALUE;
            }
        }
        return result;
    }


}
