package leetcode.swordToOffer;

public class problem17 {

    public int[] printNumbers(int n) {
        int count = 1;
        for (int i = 0; i < n; i++) {
            count *= 10;
        }
        int[] nums = new int[count - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        return nums;
    }
}
