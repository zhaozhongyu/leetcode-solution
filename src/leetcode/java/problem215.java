package leetcode.java;

public class problem215 {

    // 分段的不完全快排
    public int findKthLargest(int[] nums, int k) {
        int n = 0;
        k = nums.length - k;
        int begin = 0, end = nums.length - 1;
        while (true) {
            n = partFastSort(nums, begin, end);
            if (n == k) {
                return nums[n];
            }
            if (n > k) {
                end = n - 1;
                n = partFastSort(nums, begin, end);

            } else {
                begin = n + 1;
                n = partFastSort(nums, begin, end);
            }
        }
    }

    public int partFastSort(int[] nums, int begin, int end) {

        int i = begin, j = end;
        int n = nums[i];
        while (i < j) {
            while (i < j && nums[j] > n) {
                j --;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            // 从左向右找大于或等于x的数来填
            while (i < j && nums[i] < n) {
                i ++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = n;
        return i;
    }
}
