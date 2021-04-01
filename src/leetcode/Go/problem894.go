package main

/**
令 \text{FBT}(N)FBT(N) 作为所有含 NN 个结点的可能的满二叉树的列表。

每个满二叉树 TT 含有 3 个或更多结点，在其根结点处有 2 个子结点。这些子结点 left 和 right 本身就是满二叉树。

因此，对于 N \geq 3N≥3，我们可以设定如下的递归策略：\text{FBT}(N) =FBT(N)= [对于所有的 xx，所有的树的左子结点来自 \text{FBT}(x)FBT(x) 而右子结点来自 \text{FBT}(N-1-x)FBT(N−1−x)]。
*/
var memo = make(map[int][]*TreeNode)

func allPossibleFBT(n int) []*TreeNode {
	if n%2 == 0 {
		return nil
	}
	if memo[n] == nil {
		ret := make([]*TreeNode, 0)
		if n == 1 {
			memo[1] = []*TreeNode{&TreeNode{Val: 0}}
		} else {
			for i := 0; i < n; i++ {
				j := n - 1 - i
				for _, left := range allPossibleFBT(i) {
					for _, right := range allPossibleFBT(j) {
						node := &TreeNode{Val: 0, Left: left, Right: right}
						ret = append(ret, node)
					}
				}
			}
			memo[n] = ret
		}
	}
	return memo[n]
}
