package leetcode.java;

import java.util.Iterator;
import java.util.List;

public class problem341 {


}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
   public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

   // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nestedList;
    private Integer integer;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
    }

    @Override
    public Integer next() {
        return this.integer;
    }

    @Override
    public boolean hasNext() {
        NestedInteger nestedInteger;
        do {
            if (this.nestedList.size() != 0) {
                nestedInteger = this.nestedList.get(0);
            } else {
                return false;
            }
            if (nestedInteger.isInteger()) {
                this.nestedList.remove(0);
                this.integer = nestedInteger.getInteger();
                return true;
            } else {
                List<NestedInteger> list = nestedInteger.getList();
                this.nestedList.remove(0);
                list.addAll(this.nestedList);
                this.nestedList = list;
            }
        } while (nestedList.size() != 0);
        return false;
    }
}