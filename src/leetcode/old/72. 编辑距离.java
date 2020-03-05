package leetcode.old;

class Solution {
    public int minDistance(String word1, String word2) {
     int[][] map = new int[word1.length()+1][word2.length()+1];
        for(int i = 0; i <= word1.length(); i++ ) {
            map[i][0] = i;
        }
        for(int i = 0; i <= word2.length(); i++) {
            map[0][i] = i;
        }
        for(int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++){
                int min = Math.min(map[i][j], Math.min(map[i+1][j], map[i][j+1]));
                if(word1.charAt(i) == word2.charAt(j)) {
                    map[i+1][j+1] = map[i][j];
                } else {
                    map[i+1][j+1] = min + 1;
                }
            }
        }
        return map[word1.length()][word2.length()];
    }
}
