package leetcode.swordToOffer;

public class problem56II {

    /**
     * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
     * 示例 1：
     *
     * 输入：nums = [3,4,3,3]
     * 输出：4
     * 示例 2：
     *
     * 输入：nums = [9,1,7,9,7,9,7]
     * 输出：1
     *
     * 交换律
     * 结合律（即(a^b)^c == a^(b^c)）
     * 对于任何数x，都有x^x=0，x^0=x
     * 自反性 A XOR B XOR B = A xor 0 = A ---> A XOR B = C 则 C XOR B = A
     * */
    public int singleNumber(int[] nums) {
        return 1;
    }
}
