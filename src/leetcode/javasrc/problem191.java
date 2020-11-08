package leetcode.javasrc;

public class problem191 {

    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i ++) {
            if ((n & (1 << i)) != 0) {
                count ++;
            }
        }
        return count;
    }
}
