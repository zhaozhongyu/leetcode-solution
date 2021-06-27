package leetcode.java;

public class problem88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return ;
        }
        int p1 = m - 1, p2 = n - 1;
        while (true) {
            if (p1 == -1 || p2 == -1) {
                break;
            }
            if (nums1[p1] > nums2[p2]) {
                nums1[p1 + p2 + 1] = nums1[p1];
                p1--;
            } else {
                nums1[p1 + p2 + 1] = nums2[p2];
                p2--;
            }
        }
        if (p2 != -1) {
            for (int i = p2; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }
}
