package leetcode.tree;

import java.util.HashMap;

public class problem337 {

    /**
     * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
     *
     * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
     *
     * 示例 1:
     *
     * 输入: [3,2,3,null,3,null,1]
     *
     *      3
     *     / \
     *    2   3
     *     \   \
     *      3   1
     *
     * 输出: 7
     * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
     * 示例 2:
     *
     * 输入: [3,4,5,1,3,null,1]
     *
     *      3
     *     / \
     *    4   5
     *   / \   \
     *  1   3   1
     *
     * 输出: 9
     * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber-iii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> map = new HashMap<>();
        return maxRob(root, map);
    }



    public int maxRob (TreeNode node, HashMap<TreeNode, Integer> map) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        if (node.left == null && node.right == null) {
            map.put(node, node.val);
            return node.val;
        }
        int resultWithNode = node.val;
        int resultWithoutNode = 0;
        if (node.left != null) {
            resultWithNode += maxRob(node.left.left, map) + maxRob(node.left.right, map);
            resultWithoutNode += maxRob(node.left, map);
        }
        if (node.right != null) {
            resultWithNode += maxRob(node.right.left, map) + maxRob(node.right.right, map);
            resultWithoutNode += maxRob(node.right, map);
        }
        int result = Math.max(resultWithNode, resultWithoutNode);
        map.put(node, result);
        return result;
    }

    public void inorder (TreeNode node, HashMap<TreeNode, TreeNode> map) {
        if (node == null) return ;
        if (node.left != null) {
            map.put(node.right, node);
        }
        if (node.right != null) {
            map.put(node.right, node);
            inorder(node.right, map);
        }
    }
}
