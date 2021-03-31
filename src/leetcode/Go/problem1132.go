package main

func lcaDeepestLeaves(root *TreeNode) *TreeNode {
	var pathMap = make(map[int][]*TreeNode)
	var parentMap = make(map[*TreeNode]*TreeNode)
	var orderRoot func(root *TreeNode, path int)
	orderRoot = func(root *TreeNode, path int) {
		if root == nil {
			return
		}
		l := pathMap[path]
		if l == nil {
			l = make([]*TreeNode, 0)
		}
		l = append(l, root)
		pathMap[path] = l
		if root.Left != nil {
			parentMap[root.Left] = root
			orderRoot(root.Left, path+1)
		}
		if root.Right != nil {
			parentMap[root.Right] = root
			orderRoot(root.Right, path+1)
		}
	}
	orderRoot(root, 0)
	path := len(pathMap)
	if len(pathMap[path-1]) == 1 {
		return pathMap[path-1][0]
	}
	l := make(map[*TreeNode]bool)
	for _, v := range pathMap[path-1] {
		l[v] = true
	}
	pathMap = nil
	parentList := make(map[*TreeNode]bool)
	for {
		for node, _ := range l {
			parentList[parentMap[node]] = true
		}
		if len(parentList) == 1 {
			break
		}
		l = parentList
		parentList = make(map[*TreeNode]bool)
	}
	for k, _ := range parentList {
		return k
	}
	return root
}
