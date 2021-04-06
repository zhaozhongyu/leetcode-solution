package main

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	var left *TreeNode = p
	var right *TreeNode = q
	if left.Val > right.Val {
		tmp := left
		left = right
		right = tmp
	}
	for root != nil {
		if root.Val >= left.Val && root.Val <= right.Val {
			return root
		} else if root.Val > right.Val {
			root = root.Left
		} else {
			root = root.Right
		}
	}
	return root
}
