package algorithm.tree;


import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Stack;

public class expression {
    // 表达式计算

    // 转换为tree
    public void getTree (String str) {
        Stack<TreeNode> stack = new Stack<>();
        int isHighpriority = 0;
        TreeNode root = null;
        int start = 0;
        if (str.charAt(0) == '-') start = 1;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c <= '9' && c >= '0') {
                continue;
            }
            TreeNode node = new TreeNode(Integer.valueOf(str.substring(0, i)));
            stack.push(node);
            start = i;
        }
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {
                TreeNode node = new TreeNode(c);
                TreeNode temp = stack.pop();
                node.left = temp;
                stack.push(node);
            }
            else if (c == '*' || c == '/') { // 如果是乘除, 则把node里面的右节点置为乘除, 并把原来的右节点设为当前的左节点
                TreeNode temp = new TreeNode(c);
                TreeNode node = stack.pop();
                temp.left = node.right;
                node.right = temp;

            }
            else if (c == '(') { // 当isHighpriority 不为0时, 说明在括号内
                isHighpriority ++;
            }
            else if (c == ')') {
                isHighpriority --;
            }
            else {
                for (int j = i; j < str.length(); j++) {
                    c = str.charAt(j);
                    if (c <= '9' && c >= '0') {
                        continue;
                    }
                    TreeNode node = null;
                    if (j == str.length() - 1) {
                        node = new TreeNode(Integer.valueOf(str.substring(i, j + 1)));
                    } else {
                        node = new TreeNode(Integer.valueOf(str.substring(i, j)));
                    }
                    stack.push(node);
                }
            }
        }
    }

    // Tree计算

    // https://www.cnblogs.com/xzxj/p/6534998.html
    /**
     * 1.将中缀表达式转换为后缀表达式的方法：
     * (1) 初始化两个栈：运算符栈S1和储存中间结果的栈S2；
     * (2) 从左至右扫描中缀表达式；
     * (3) 遇到操作数时，将其压入S2，这里由于运算数可能大于10，所以如果数字后面一个符号是运算符，则将‘#’入S2栈充当分割线；
     * (4) 遇到运算符时有三种情况：
     * (4-1) 三种情况下直接入S1栈 ①S1为空 ②运算符为‘（’ ③运算符优先级比S1栈顶运算符的高；
     * (4-2)如果右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃；
     * (4-3) 若运算符优先级小于或等于S1栈顶运算符的优先级，则依次弹出S1栈顶元素，直到运算符的优先级大于S1栈顶运算符优先级；
     * (6) 重复步骤(2)至(5)，直到表达式的最右边；
     * (7) 将S1中剩余的运算符依次弹出并压入S2；
     * (8) 依次弹出S2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式。
     *
     * 运算符优先级： 左括号>（乘=除）>（加=减）>右括号  为了编程方便假定右括号优先级最小。
     * */
    public void calcute (String str) {
        Stack<Character> s1 = new Stack<>(); // 存储操作数
        Stack<Character> s2 = new Stack<>(); // 存储中间结果
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 3);
        map.put(')', 0);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (!s2.isEmpty() && s2.peek() <= '9' && s2.peek() >= '0') {
                    s2.push('#');
                }
                if (s1.isEmpty()) {  //S1为空时压入s1
                    s1.push(c);
                    continue;
                }
                char last = s1.peek();
                int cp = map.get(c);
                int lastp = map.get(last);
                if (cp < lastp) { // 如果当前的运算符比s1栈顶的运算符优先级高, 也就是乘除对加减
                    s1.push(c);
                }
                else if (map.get(last) >= map.get(c)) { // 若运算符优先级小于或等于S1栈顶运算符的优先级, 则依次弹出S1栈顶元素，直到运算符的优先级大于S1栈顶运算符优先级
                    char c1 = s1.peek();
                    while (map.get(c1) < map.get(c)) {
                        s1.pop();
                        s2.push(c1);
                        if (s1.isEmpty()) break;
                        c1 = s1.peek();
                    }
                    s1.push(c);
                }
            }
            else if (c == '(') { // 运算符为'('时压入s1
                if (!s2.isEmpty() && s2.peek() <= '9' && s2.peek() >= '0') {
                    s2.push('#');
                }
                s1.push(c);
            }
            else if (c == ')') { // 如果右括号“)”，则依次弹出S1栈顶的运算符，并压入S2，直到遇到左括号为止，此时将这一对括号丢弃
                char c1 = s1.pop();
                while (c1 != '(') {
                    s2.push(c1);
                    c1 = s1.pop();
                }
            }
            else { // 数字
//                StringBuffer sb = new StringBuffer();
//                for (int j = i; j < str.length(); j++) {
//                    char c1 = str.charAt(j);
//                    if (c1 >= '0' && c1 <= '9') {
//                        sb.append(c1);
//                    } else {
//                        i = j-1;
//                        break;
//                    }
//                }
                s2.push(c);
            }
        }
        // 将S1中剩余的运算符依次弹出并压入S2；
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        System.out.print(s2);
    }

    public static void main(String[] args) {
        new expression().calcute("1+((23+34)*5)-6");
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
    }

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}