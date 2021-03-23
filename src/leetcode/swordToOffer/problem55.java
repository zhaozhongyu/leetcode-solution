package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.Stack;

public class problem55 {

    public int maxDepth(TreeNode root) {
        TreeNode node;
        int num = 0;
        Stack<TreeNode> list = new Stack<>();
        if(root != null){
            root.val = 1;
            list.push(root);
        }

        while(list.size() != 0){
            node = list.pop();
            if(node.left != null){
                node.left.val = node.val + 1;
                list.push(node.left);
            }
            if(node.right != null) {
                node.right.val = node.val + 1;
                list.push(node.right);
            }
            if(node.left == null && node.right == null && node.val > num) {
                num = node.val;
            }
        }
        return num;
    }
}
