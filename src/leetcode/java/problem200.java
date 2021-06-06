package leetcode.java;

public class problem200 {
    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     *
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     *
     * 此外，你可以假设该网格的四条边均被水包围。
     * */
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i ++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (grid[i][j] == '1') {
                    // 下右判断, 当前相连的全部去掉
                    markIsland(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    // grid[i][j] 为'1', 标记整个岛
    public void markIsland(char[][] grid, int i, int j) {
        grid[i][j] = 'v';
        if (i - 1 >= 0 && grid[i-1][j] == '1') {
            markIsland(grid, i-1, j);
        }
        if (j - 1 >= 0 && grid[i][j-1] == '1') {
            markIsland(grid, i, j - 1);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            markIsland(grid, i+1, j);
        }
        if (j + 1 < grid[0].length && grid[i][j+1] == '1') {
            markIsland(grid, i, j+1);
        }
    }
}
