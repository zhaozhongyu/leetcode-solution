package leetcode.tree;

public class problem04 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid = (nums1.length + nums2.length - 1) / 2;
        int p1 = 0, p2 = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (p1 + p2 == mid) {
                break;
            }
            if (nums1[p1] <= nums2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }
        if (p1 == nums1.length) {
            p2 = mid - p1;
        } else if (p2 == nums2.length) {
            p1 = mid - p2;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            if (p1 < nums1.length && p2 < nums2.length) {
                return Math.min(nums1[p1], nums2[p2]);
            }
            if (p1 < nums1.length) {
                return nums1[p1];
            } else {
                return nums2[p2];
            }
        }
        if (p1 >= nums1.length) {
            return (double)(nums2[p2] + nums2[p2+1]) / 2;
        }
        if (p2 >= nums2.length){
            return (double)(nums1[p1]+ nums1[p1+1]) /2;
        }
        double res = 0;
        if (nums1[p1] < nums2[p2]) {
            res = nums1[p1++];
        } else {
            res = nums2[p2++];
        }
        if (p1 >= nums1.length) {
            return (res + nums2[p2]) / 2;
        }
        if (p2 >= nums2.length) {
            return (res + nums1[p1]) / 2;
        }
        return (res + Math.min(nums1[p1], nums2[p2])) / 2;
    }
}
