package leetcode.swordToOffer;

import java.util.ArrayList;
import java.util.LinkedList;

public class problem41 {
    /**
     * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
     *
     * 例如，
     *
     * [2,3,4] 的中位数是 3
     *
     * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
     *
     * 设计一个支持以下两种操作的数据结构：
     *
     * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
     * double findMedian() - 返回目前所有元素的中位数。
     * 示例 1：
     *
     * 输入：
     * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
     * [[],[1],[2],[],[3],[]]
     * 输出：[null,null,null,1.50000,null,2.00000]
     * 示例 2：
     *
     * 输入：
     * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
     * [[],[2],[],[3],[]]
     * 输出：[null,null,2.00000,null,2.50000]
     * */

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(12);
        mf.addNum(10);
        mf.addNum(13);
        mf.addNum(5);
        mf.addNum(15);
        mf.addNum(11);
        mf.addNum(6);
        mf.addNum(17);
        mf.addNum(14);
        mf.addNum(8);
        mf.addNum(17);
        mf.addNum(6);
        mf.addNum(4);
        mf.addNum(16);
        mf.addNum(8);
        mf.addNum(10);
        mf.addNum(2);
        mf.addNum(12);
//        mf.addNum(12);
        mf.addNum(0);
    }
}
class MedianFinder {
    ArrayList<Integer> list;
    public MedianFinder() {
        list = new ArrayList<Integer>();
    }

    public void addNum(int num) {
        int size = list.size();
        insert(num, 0, size - 1);
    }

    private void insert(int num, int start, int end) {
        if (start > end) {
            list.add(start, num);
            return;
        }
        if (start == end) {
            if (list.get(start) > num) {
                list.add(start, num);
            } else {
                list.add(start + 1, num);
            }
            return;
        }
        int n = (start + end - 1) / 2;
        if (list.get(n) == num) {
            list.add(n, num);
        } else if (list.get(n) < num && list.get(n + 1) >= num) {
            list.add(n+1, num);
        } else if (list.get(n) < num) {
            insert(num, n + 1, end);
        } else {
            insert(num, start, n - 1);
        }
    }

    public double findMedian() {
        double median = 0.0;
        int size = list.size();
        if (size % 2 == 0) {
            int n1 = list.get(size / 2 - 1);
            int n2 = list.get(size / 2 );
            median = ((double)(n1 + n2)) / 2;
        } else {
            median = list.get((size - 1) / 2);
        }
        return median;
    }
}
