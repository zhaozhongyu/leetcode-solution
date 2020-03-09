package leetcode;

import java.util.Stack;

public class problem84 {
//    public int largestRectangleArea(int[] heights) {
//        if (heights.length == 0) return 0;
//        int rect = 0;
//        for (int i = 0; i < heights.length; i++) { // 从1开始
//            int min = heights[i];
//            for (int j = i; j < heights.length; j++) {
//                min = Math.min(min, heights[j]);
//                rect = Math.max(rect, min * (j-i+1));
//            }
//        }
//        return  rect;
//    }

    public int largestRectangleArea(int[] heights) {
        Stack < Integer > stack = new Stack< >();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; ++i) {
            int h = heights[i];
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int pop = stack.pop();
                int peek = stack.peek();
                maxarea = Math.max(maxarea, heights[pop] * (i - peek - 1));
            }

            stack.push(i);
        }
        while (stack.peek() != -1)
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        return maxarea;
    }


    public static void main(String[] args ) {
        int[] nums = new int[]{2,1,5,6,2,3};
        System.out.print(new problem84().largestRectangleArea(nums));
    }
}
