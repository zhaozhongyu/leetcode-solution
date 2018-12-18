class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list;
        List<Integer> column;
        if (numRows < 1) return lists;
        else
            lists.add(new ArrayList<Integer>(Arrays.asList(1)));
        for (int i = 2; i <= numRows; i++) {
            list = lists.get(i-2);
            column = new ArrayList<Integer>(Arrays.asList(1));
            for(int j = 1; j < i; j++) {
                if (j == i - 1) {
                    column.add(1);
                } else {
                    column.add(list.get(j) + list.get(j-1));
                }
            }
            lists.add(column);
        }
        return lists;
    }
}
