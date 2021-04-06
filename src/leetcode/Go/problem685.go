package main

// 计算有向无环图
func findRedundantDirectedConnection(edges [][]int) []int {
	var find func([]int, int) int
	find = func(anc []int, child int) int {
		if anc[child] != child {
			anc[child] = find(anc, anc[child])
		}
		return anc[child]
	}
	var union func(anc []int, from, to int) bool
	union = func(anc []int, from, to int) bool { // 计算是否构成环
		x, y := find(anc, from), find(anc, to)
		if x == y { // 这时候说明遇到了环
			return false
		}
		anc[x] = y
		return true
	}
	parent := make([]int, len(edges)+1)
	anc := make([]int, len(edges)+1)
	var edge1 []int = nil
	for i := range parent {
		parent[i] = i
		anc[i] = i
	}
	isUnion := false
	for _, e := range edges {
		if parent[e[1]] != e[1] { // 这里说明已经有一条入度边了, 跳过这条边继续合并
			if isUnion { // 如果在发现双入度边之前就构成环
				return []int{parent[e[1]], e[1]}
			} else {
				edge1 = e
				continue
			}
		}
		if !union(anc, e[0], e[1]) { // 这里说明已经构成了环
			if edge1 != nil { // 这里说明跳过的那条边才是正确的入度边
				ret := make([]int, 2)
				ret[0] = parent[edge1[1]]
				ret[1] = edge1[1]
				return ret
			} else {
				isUnion = true
				edge1 = e
			}
		}
		parent[e[1]] = e[0]
	}
	return edge1
}
