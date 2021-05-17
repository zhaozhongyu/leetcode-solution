package leetcode.java;

import java.util.HashMap;

public class problem560 {

    public int subarraySum(int[] nums, int k) {
        // 利用哈希表实现线性寻找
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int i;
        int sum = 0;
        int count = 0;
        for (i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            // sum 代表整个数组的和, 那么sum-k就代表了0~j之间的某个子数组的和, 如果出现过, 则表示j~i这里的子数组的和为k, 这里的数字不认为为0的原因是要兼容负数存在
            if (hashMap.containsKey(sum - k))   // 表示连续子数组减去连续子数组，必定为连续子数组
            {
                count += hashMap.get(sum - k);
            }
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new problem560().subarraySum(new int[]{1,2,3,3,2,1,2}, 3));
    }
}
