package leetcode.swordToOffer;

import java.util.HashMap;

public class problem39 {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     *
     *  
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
     * 输出: 2
     * */
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], tmp);
            if (tmp > nums.length / 2) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        new problem39().majorityElement(new int[]{1,2,3,2,2,2,5,4,2});
    }
}
