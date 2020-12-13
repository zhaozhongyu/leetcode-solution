package leetcode.swordToOffer;

import java.util.LinkedList;
import java.util.Queue;

public class problem59 {

    /**
     * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
     *
     * 示例:
     *
     * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
     * 输出: [3,3,5,5,6,7]
     * 解释:
     *
     *   滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     *  1 [3  -1  -3] 5  3  6  7       3
     *  1  3 [-1  -3  5] 3  6  7       5
     *  1  3  -1 [-3  5  3] 6  7       5
     *  1  3  -1  -3 [5  3  6] 7       6
     *  1  3  -1  -3  5 [3  6  7]      7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        MaxQueue queue = new MaxQueue();
        for (int i = 0; i < k; i++) {
            queue.push_back(nums[i]);
        }
        int[] res = new int[nums.length - k + 1];
        res[0] = queue.max_value();
        for (int i = k; i < nums.length; i ++) {
            queue.pop_front();
            queue.push_back(nums[i]);
            res[i - k + 1] = queue.max_value();
        }
        return res;
    }

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
