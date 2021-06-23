package leetcode.java;

import java.util.Arrays;
import java.util.Comparator;

public class problem406 {
    /**
     * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
     *
     * 请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
     * */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

}
