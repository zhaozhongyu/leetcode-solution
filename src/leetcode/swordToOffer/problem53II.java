package leetcode.swordToOffer;

public class problem53II {

    /**
     *
     一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * */
    public int missingNumber(int[] nums) {
        if (nums.length == 0 ) {
            return 0;
        }
        int mid = (nums.length - 1) / 2;
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (mid < nums.length - 1) {
                if (nums[mid] == mid && nums[mid + 1] > mid + 1) {
                    return mid + 1;
                }
            } else {
                break;
            }
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return nums[mid] == mid? mid + 1: mid;
    }

//    public static void main(String[] ar) {
//        int[] nums = new int[]{0,1,2,3,4,5,6,7,9};
//        new problem54().missingNumber(nums);
//    }
}
