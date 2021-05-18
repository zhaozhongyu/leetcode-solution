package leetcode.java;

public class problem338 {
    /**
     * 示例 1:
     *
     * 输入: 2
     * 输出: [0,1,1]
     * 示例 2:
     *
     * 输入: 5
     * 输出: [0,1,1,2,1,2]
     * */
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        int last = 1;
        for (int i = 0; i < num;i++) {
            if (last <= num) {
                ret[last] = 1;
            } else {
                break;
            }
            last = last * 2;
        }
        int lastnum = 1;
        for (int i = 3; i <= num; i++) {
            if (ret[i] == 0) {
                ret[i] = ret[i - lastnum] + 1;
            } else {
                lastnum = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new problem338().countBits(2).toString());
    }
}
