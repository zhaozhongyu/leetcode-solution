package main

var maxPath int = 0

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}
	maxPath = 0
	getMaxPath(root, root.Val)
	return maxPath
}
func getMaxPath(root *TreeNode, val int) int {
	if root == nil {
		return 0
	}
	left := getMaxPath(root.Left, root.Val)
	right := getMaxPath(root.Right, root.Val)

	if left+right > maxPath { // 路径长度为节点数减1所以此处不加1
		maxPath = left + right
	}
	if root.Val == val { // 和父节点值相同才返回以当前节点所能构成的最长通知路径长度, 否则返回0
		if left > right {
			return left + 1
		} else {
			return right + 1
		}
	}
	return 0
}
