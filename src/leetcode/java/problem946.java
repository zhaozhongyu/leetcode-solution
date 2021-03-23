package leetcode.java;

import java.util.Stack;

public class problem946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        }
        if (pushed.length == 0 || popped.length == 0) {
            return  false;
        }
        Stack<Integer> stack = new Stack<>();
        int pushindex = 0;
        int popindex = 0;
        while (true) {
            if (stack.empty()) {
                if (pushindex < pushed.length) {
                    stack.push(pushed[pushindex++]);
                } else if (popindex < popped.length) {
                    return false;
                } else {
                    return true;
                }
            }
            if (stack.peek() == popped[popindex]) {
                popindex ++;
                stack.pop();
            } else if (pushindex < pushed.length) {
                stack.push(pushed[pushindex++]);
            } else {
                return false;
            }
        }
    }
}
