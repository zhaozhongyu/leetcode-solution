package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class problem59II {
    /**
     * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
     *
     * 若队列为空，pop_front 和 max_value 需要返回 -1
     *
     * 示例 1：
     *
     * 输入:
     * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
     * [[],[1],[2],[],[],[]]
     * 输出: [null,null,null,2,1,2]
     * 示例 2：
     *
     * 输入:
     * ["MaxQueue","pop_front","max_value"]
     * [[],[],[]]
     * 输出: [null,-1,-1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    class MaxQueue {
        private Queue<Integer> queue;
        private LinkedList<Integer> maxQueue;
        public MaxQueue() {
            queue = new LinkedList<>();
            maxQueue = new LinkedList<>();
        }

        public int max_value() {
            if (queue.isEmpty()) {
                return -1;
            }
            return maxQueue.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            if (maxQueue.isEmpty()) {
                maxQueue.add(value);
            } else if (value > maxQueue.peek()) {
                maxQueue.clear();
                maxQueue.add(value);
            } else {
                while (maxQueue.getLast() < value) {
                    maxQueue.removeLast();
                }
                maxQueue.addLast(value);
            }
        }

        public int pop_front() {
            if (queue.isEmpty() || maxQueue.isEmpty()) {
                return -1;
            }
            int res = queue.poll();
            if (res == maxQueue.peek()) {
                maxQueue.poll();
            }
            return res;
        }
    }
}
