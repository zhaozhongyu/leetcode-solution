package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class problem235 {

    /**
     * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
     *
     * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     *
     * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
     * 示例 1:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
     * 输出: 6
     * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
     * 示例 2:
     *
     * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
     * 输出: 2
     * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> listp = new ArrayList<>();
        ArrayList<TreeNode> listq = new ArrayList<>();
        findAncestor(root, p, listp);
        findAncestor(root, q, listq);
        int end = Math.min(listp.size(), listq.size()) - 1;
        for (int i = end; i >= 0; i--) {
            if (listp.get(i) == listq.get(i)) {
                return listp.get(i);
            }
        }
        return root;
    }

    public void findAncestor (TreeNode node, TreeNode sub, List<TreeNode> list) {
        list.add(node);
        if (node.val == sub.val) {
            return;
        }
        if (node.val > sub.val) {
            findAncestor(node.left, sub, list);
        }
        else {
            findAncestor(node.right, sub, list);
        }
    }

//    public static void main(String[] args) {
//        Integer[] nums = new Integer[]{6,2,8,0,4,7,9,null,null,3,5};
//        TreeNode node = TreeNode.createTreeNode(nums);
//        new problem235().lowestCommonAncestor(node, new TreeNode(2), new TreeNode(8));
//    }
}
