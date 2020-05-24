package leetcode.tree;

import java.util.Stack;

public class problem606 {

    /**
     * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
     *
     * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/construct-string-from-binary-tree
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public String tree2str(TreeNode t) {
        if (t == null) return  "";
        StringBuffer sb = new StringBuffer();
        sb.append(t.val);
        if (t.left != null)  {
            sb.append("(").append(tree2str(t.left)).append(")");
        } else if (t.right != null) {
            sb.append("()");
        }
        if (t.right != null) sb.append("(").append(tree2str(t.right)).append(")");
        return sb.toString();
    }
}
