package leetcode.tree;

public class problem559 {

    /**
     * 给定一个 N 叉树，找到其最大深度。
     *
     * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
     * */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null || root.children.size() == 0) return 1;
        int result = 0;
        for (int i = 0; i < root.children.size(); i++) {
            Node node = root.children.get(i);
            result = Math.max(result, maxDepth(node));
        }
        return result+1;
    }
}
