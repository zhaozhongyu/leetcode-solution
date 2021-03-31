package main

func distanceK(root *TreeNode, target *TreeNode, K int) []int {
	var parentNode = make(map[*TreeNode]*TreeNode)
	var visited = make(map[*TreeNode]bool)
	var orderTree func(root *TreeNode)
	orderTree = func(root *TreeNode) {
		if root == nil {
			return
		}
		if root.Left != nil {
			parentNode[root.Left] = root
			orderTree(root.Left)
		}
		if root.Right != nil {
			parentNode[root.Right] = root
			orderTree(root.Right)
		}
	}
	orderTree(root)
	ret := make([]int, 0)
	var order func(target *TreeNode, K int, ret []int) []int
	// 子节点
	order = func(target *TreeNode, K int, ret []int) []int {
		visited[target] = true
		if K == 0 {
			return append(ret, target.Val)
		}
		if target.Left != nil && visited[target.Left] == false {
			ret = order(target.Left, K-1, ret)
		}
		if target.Right != nil && visited[target.Right] == false {
			ret = order(target.Right, K-1, ret)
		}
		if parentNode[target] != nil && visited[parentNode[target]] == false {
			ret = order(parentNode[target], K-1, ret)
		}
		return ret
	}
	return order(target, K, ret)
}
