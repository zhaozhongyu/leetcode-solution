package main

func countPairs(root *TreeNode, distance int) int {
	if root == nil {
		return 0
	}
	_, ret := orderPairs(root, distance)
	return ret
}

// 返回值中每个值都要低于distance, 保证root不为nil
func orderPairs(root *TreeNode, distance int) ([]int, int) {
	if root.Left == nil && root.Right == nil {
		return []int{1}, 0
	}
	var count = 0
	var left, right []int
	if root.Left != nil {
		var leftCount int
		left, leftCount = orderPairs(root.Left, distance)
		count += leftCount
	}
	if root.Right != nil {
		var rightCount int
		right, rightCount = orderPairs(root.Right, distance)
		count += rightCount
	}
	var ret = make([]int, 0)
	for _, i := range left {
		for _, j := range right {
			if i+j <= distance {
				count++
			}
		}
	}
	for _, i := range left {
		if i+1 <= distance {
			ret = append(ret, i+1)
		}
	}
	for _, i := range right {
		if i+1 <= distance {
			ret = append(ret, i+1)
		}
	}
	return ret, count
}
