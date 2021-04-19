package main

func isValidBST(root *TreeNode) bool {
	last := make([]int, 0)
	if root == nil {
		return true
	}
	var inOrder func(node *TreeNode, val []int) (bool, []int)
	inOrder = func(node *TreeNode, val []int) (bool, []int) {
		var ret bool
		if node.Left != nil {
			ret, val = inOrder(node.Left, val)
			if !ret {
				return false, val
			}
		}
		if len(val) == 0 {
			val = append(val, node.Val)
		} else {
			if node.Val <= val[0] {
				return false, val
			} else {
				val[0] = node.Val
			}
		}
		if node.Right != nil {
			ret, val = inOrder(node.Right, val)
			if !ret {
				return false, val
			}
		}
		return true, val
	}
	ret, _ := inOrder(root, last)
	return ret
}
