package algorithm.tree;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class expression {
    // 表达式计算

    // 简单递归
    public int calcuteStr (String str) {
        LinkedList<String> list = new LinkedList<>();
        str = str.replaceAll(" ", ""); // 去掉所有空格
        if (str.length() > 0) {
            if (str.charAt(0) == '-') { // 去掉首负号, 将负号替换为~
                str = '~' + str.substring(1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                list.add(String.valueOf(c));
                if (str.charAt(i+1) == '-') { // 算术符后面的负号替换为~
                    c = '~';
                    i++;
                }
            } else if (c == '(') { // 将整个括号中的内容进行递归
                int num = 1;
                int end = 0;
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(j) == '(') num++;
                    if (str.charAt(j) == ')') num--;
                    if (num == 0) {
                        end = j + 1;
                        break;
                    }
                }
                String subexpression = str.substring(i+1, end-1);
                list.add(String.valueOf(calcuteStr(subexpression)));
                i = end;
            }
            if ((c >= '0' && c <= '9') || c == '~') {
                StringBuffer sb = new StringBuffer();
                if (c == '~') {
                    sb.append('-');
                } else {
                    sb.append(c);
                }
                for (int j = i + 1; j < str.length(); j++) {
                    c = str.charAt(j);
                    if (c >= '0' && c <= '9') {
                        sb.append(c);
                    } else {
                        i = j - 1;
                        break;
                    }
                    if (j == str.length()-1) {
                        i = j;
                    }
                }
                list.add(sb.toString());
            } else if (c == ' ') {
                continue;
            }
//            else {
//                System.out.println(c);
//                throw new RuntimeException("wrong expression!");
//            }
        }
        for (int i = 1; i < list.size()-1; i++) { // 第一趟扫描, 计算所有的乘除
            String s = list.get(i);
            if (s.equals("*") || s.equals("/")) {
                String last = list.get(i-1);
                String next = list.get(i+1);
                int result = 0;
                if (s.equals("*")) {
                    result = Integer.valueOf(last) * Integer.valueOf(next);
                } else {
                    result = Integer.valueOf(last) / Integer.valueOf(next);
                }
                list.remove(i+1);
                list.remove(i);
                list.remove(i-1);
                list.add(i-1, String.valueOf(result));
                i = i-1;
            }
        }
        for (int i = 1; i < list.size()-1; i++) { // 第二趟扫描, 计算所有的加减
            String s = list.get(i);
            if (s.equals("+") || s.equals("-")) {
                String last = list.get(i-1);
                String next = list.get(i+1);
                int result = 0;
                if (s.equals("+")) {
                    result = Integer.valueOf(last) + Integer.valueOf(next);
                } else {
                    result = Integer.valueOf(last) - Integer.valueOf(next);
                }
                list.remove(i+1);
                list.remove(i);
                list.remove(i-1);
                list.add(i-1, String.valueOf(result));
                i = i-1;
            }
        }
        if (list.size() > 1) throw new RuntimeException("work error");
        return Integer.parseInt(list.get(0));
    }

    public static void main(String[] args) {
        // 1+2*3+-4/5*-6
        new expression().calcuteStr("1 + ( ( 23 + 34 ) * 5 ) - 6");
    }



}


class TreeNode {
    int val;
    char symbol;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode (char symb) {
        if (symb != '+' || symb != '-' || symb != '*' || symb != '-') {
            throw new RuntimeException("wrong symbol!");
        }
        symbol = symb;
        val = Integer.MIN_VALUE;
    }

    TreeNode(int x) {
        val = x;symbol = Character.MIN_VALUE;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}