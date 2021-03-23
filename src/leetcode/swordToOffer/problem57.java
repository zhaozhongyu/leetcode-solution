package leetcode.swordToOffer;

import java.util.HashMap;
import java.util.HashSet;

public class problem57 {

    /**
     * 示例 1：
     *
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[2,7] 或者 [7,2]
     * 示例 2：
     *
     * 输入：nums = [10,26,30,31,47,60], target = 40
     * 输出：[10,30] 或者 [30,10]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] res = new int[2];
        for (int i : nums) {
            if (i != target - i) {
                if (map.containsKey(target - i)) {
                    res[0] = i;
                    res[1] = target - i;
                    break;
                }
            } else {
                if (map.getOrDefault(i, 0) > 1) {
                    res[0] = i;
                    res[1] = i;
                    break;
                }
            }
        }
        return res;
    }
}
