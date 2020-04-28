package leetcode;

public class problem80 {

    public int removeDuplicates(int[] nums) {

        if (nums.length == 0) return 0;
        int last = nums[0];
        int num = 1;
        int offset = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == last) {
                if (num >= 2 && offset == -1) {
                    offset = i;
                } else if (num < 2) {
                    if (offset != -1) {
                        nums[offset++] = nums[i];
                    }
                    num++;
                }
            } else {
                num = 1;
                last = nums[i];
                if (offset != -1) {
                    nums[offset++] = nums[i];
                }
            }
        }
        return offset == -1? nums.length : offset;
    }

//    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,1,2,2,3};
//        System.out.print(new problem80().removeDuplicates(nums));
//    }
}
