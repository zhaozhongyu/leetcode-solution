package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func CreateTreeNode(nums []int) *TreeNode {
	var root = &TreeNode{Val: nums[0], Left: nil, Right: nil}
	var l []*TreeNode
	l = append(l, root)
	for i := 1; i < len(nums); i += 2 {
		node := l[0]
		l = l[1:]
		if nums[i] != -1 {
			node.Left = &TreeNode{Val: nums[i]}
			l = append(l, node.Left)
		}
		if i+1 < len(nums) && nums[i+1] != -1 {
			node.Right = &TreeNode{Val: nums[i+1]}
			l = append(l, node.Right)
		}
	}
	return root
}
