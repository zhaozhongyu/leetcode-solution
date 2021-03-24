package leetcode.java;

public class interviewProblem0402 {
    // 根据一个中序遍历数组转换成树
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    public TreeNode buildBST(int[]nums, int begin, int end) {
        if (begin > end) {
            return null;
        }
        if (begin == end) {
            return new TreeNode(nums[begin]);
        }
        int mid = (end + begin + 1) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildBST(nums, begin, mid - 1);
        node.right = buildBST(nums, mid + 1, end);
        return node;
    }
}
