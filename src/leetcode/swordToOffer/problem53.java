package leetcode.swordToOffer;

public class problem53 {

    public int search(int[] nums, int target) {
        if (nums.length == 0 ) {
            return 0;
        }
        int mid = (nums.length - 1) / 2;
        int left = 0;
        int right = nums.length - 1;
        while (left < right && nums[mid] != target) {
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        if (nums[mid] != target) {
            return 0;
        }
        int result = 1;
        for (int i = mid + 1; i < nums.length ; i++) {
            if (nums[i] != target) {
                break;
            }
            result++;
        }
        for (int i = mid - 1; i >= 0; i --) {
            if (nums[i] != target) {
                break;
            }
            result ++;
        }
        return result;
    }

//    public static void main(String[] ar) {
//        int[] nums = new int[]{5,7,7,8,8,10};
//        new problem53().search(nums, 8);
//    }
}
