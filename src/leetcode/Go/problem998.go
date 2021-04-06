package main

func insertIntoMaxTree(root *TreeNode, val int) *TreeNode {
	if root == nil {
		return &TreeNode{Val: val}
	}
	if root.Val < val {
		node := &TreeNode{Val: val}
		node.Left = root
		return node
	}
	root.Right = insertIntoMaxTree(root.Right, val)
	return root
}
