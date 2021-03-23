package leetcode.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class problem684 {
    /**
     * 在本问题中, 树指的是一个连通且无环的无向图。
     *
     * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
     *
     * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
     *
     * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
     * */
    public int[] findRedundantConnection(int[][] edges) {
        HashMap<Integer, Integer> map = new HashMap<>(); //邻接表表示法
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            if(map.containsKey(edge[0]) && map.containsKey(edge[1])) {
                return edge;
            }
            else {
                map.put(edge[0], map.getOrDefault(edge[0],0)+1);
                map.put(edge[1], map.getOrDefault(edge[1],0)+1);
            }
//            if (!map.containsKey(edge[0])) {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(edge[1]);
//                map.put(edge[0], list);
//            } else {
//                map.get(edge[0]).add(edge[1]);
//            }
//            if (! map.containsKey(edge[1])) {
//                ArrayList<Integer> list = new ArrayList<>();
//                list.add(edge[0]);
//                map.put(edge[1], list);
//            } else {
//                map.get(edge[1]).add(edge[0]);
//            }
        }
        return edges[edges.length-1];

    }

//    public boolean checkConn (HashMap<Integer, List<Integer>> map, int[] edge) {
//        List<Integer> list = map.get(edge[0]);
//
//    }
}
