package leetcode.java;

import java.util.ArrayList;

public class problem295 {
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
                list.add(n + 1, num);
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
                int n2 = list.get(size / 2);
                median = ((double) (n1 + n2)) / 2;
            } else {
                median = list.get((size - 1) / 2);
            }
            return median;
        }
    }
}
