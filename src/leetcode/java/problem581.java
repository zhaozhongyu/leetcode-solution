package leetcode.java;

public class problem581 {

    public int findUnsortedSubarray(int[] nums) {
        if (nums.length < 2) return 0;
        int min = nums[0], max = nums[0], left = 0, right = 0;
        // 找到第一个不是递增的元素位置
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                min = nums[i + 1];
                max = nums[i];
                left = i;
                break;
            }
            if (i == nums.length - 2) {
                return 0;
            }
        }
        // 从找到的位置往后查找, 直到最后, 并更新right和max/min
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] < min) {
                right = i;
                min = nums[i];
            }
            if (nums[i] < max) { // 比左边某个值小, 说明这个也不是递增
                right = i;
            } else {
                max = nums[i];
            }
        }
        // 从找到的地方往前查找, 因为查找过一次, 只需要判断min即可
        for (int i = left - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                break;
            }
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new problem581().findUnsortedSubarray(new int[]{1}));
    }
}
