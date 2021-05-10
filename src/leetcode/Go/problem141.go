package main

// 快慢指针解决
func hasCycle(head *ListNode) bool {
	fast := head
	slow := head
	ret := false
	for {
		if fast == nil || fast.Next == nil {
			break
		}
		slow = slow.Next
		fast = fast.Next.Next
		if slow == fast {
			ret = true
			break
		}
	}
	return ret
}
