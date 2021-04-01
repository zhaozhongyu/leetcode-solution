package main

// 如果前序遍历的第一个值与后序遍历最后一个值一样, 则它可以作为根节点
// 如果前序遍历的第一个值和后序遍历的最后一个值不一样, 则前序遍历的第一个值作为新的左孩子, 后序遍历的最后一个值作为新的右孩子, 然后分别找到这两个值在前/后序遍历的位置, 拆分开来, 递归
func constructFromPrePost(pre []int, post []int) *TreeNode {
	left, right := orderFromPrePost(pre, post)
	if right != nil {
		left.Right = right
	}
	return left
}

func orderFromPrePost(pre []int, post []int) (*TreeNode, *TreeNode) {
	if len(pre) == 0 {
		return nil, nil
	}
	if len(pre) == 1 {
		return &TreeNode{Val: pre[0]}, nil
	}
	if len(pre) == 2 {
		if pre[0] == post[0] {
			return &TreeNode{Val: pre[0]}, &TreeNode{Val: pre[1]}
		} else {
			parent := &TreeNode{Val: pre[0]}
			parent.Left = &TreeNode{Val: pre[1]}
			return parent, nil
		}
	}
	length := len(post)
	if pre[0] == post[length-1] {
		node := &TreeNode{Val: pre[0]}
		node.Left, node.Right = orderFromPrePost(pre[1:], post[:length-1])
		return node, nil
	}
	left := &TreeNode{Val: pre[0]}
	right := &TreeNode{Val: post[length-1]}
	var preIndex, postIndex int
	for i := range pre {
		if pre[i] == post[length-1] {
			preIndex = i
			break
		}
	}
	for i := range post {
		if post[i] == pre[0] {
			postIndex = i
			break
		}
	}
	left.Left, left.Right = orderFromPrePost(pre[1:preIndex], post[:postIndex])
	right.Left, right.Right = orderFromPrePost(pre[preIndex+1:], post[postIndex+1:length-1])
	return left, right
}
