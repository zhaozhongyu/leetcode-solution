package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.List;

public class problem06 {

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
             list.add(head.val);
             head = head.next;
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(list.size() - 1 - i);
        }
        return res;
    }
}
