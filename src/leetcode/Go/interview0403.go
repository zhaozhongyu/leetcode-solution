package main

func listOfDepth(tree *TreeNode) []*ListNode {
	if tree == nil {
		return []*ListNode{}
	}
	treeList := make([]*TreeNode, 0)
	deep := make([]int, 0)
	ret := make([]*ListNode, 0)
	lastNodeList := make([]*ListNode, 0)
	treeList = append(treeList, tree)
	deep = append(deep, 0)
	for len(treeList) != 0 {
		currentPath := deep[0]
		deep = deep[1:]
		tree = treeList[0]
		treeList = treeList[1:]
		if tree.Left != nil {
			treeList = append(treeList, tree.Left)
			deep = append(deep, currentPath+1)
		}
		if tree.Right != nil {
			treeList = append(treeList, tree.Right)
			deep = append(deep, currentPath+1)
		}
		if len(ret) <= currentPath {
			listNode := &ListNode{Val: tree.Val}
			ret = append(ret, listNode)
			lastNodeList = append(lastNodeList, listNode)
		} else {
			listNode := lastNodeList[currentPath]
			listNode.Next = &ListNode{Val: tree.Val}
			lastNodeList[currentPath] = listNode.Next
		}
	}
	return ret
}
