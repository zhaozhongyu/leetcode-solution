package leetcode.swordToOffer;

import java.util.Stack;

public class problem30 {


}

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty() || x <= min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.empty()) return;
        int x = stack.pop();
        if (x == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (stack.empty()) return 0;
        return stack.peek();
    }

    public int min() {
        if (min.empty()) return 0;
        return min.peek();
    }
}