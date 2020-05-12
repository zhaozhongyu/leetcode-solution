package algorithm.tree;



import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class expression {
    // 表达式计算

    // 简单递归
    public int calcuteStr (String str) {
        LinkedList<String> list = new LinkedList<>();
        if (str.length() > 0) {
            if (str.charAt(0) == '-') { // 去掉首负号, 将负号替换为~
                str = '~' + str.substring(1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                list.add(String.valueOf(c));
                while (str.charAt(++i) == ' ') {} // 跳过后面的空格
                if (str.charAt(i) == '-') { // 算术符后面的负号替换为~
//                    char[] chars = str.toCharArray();
//                    chars[i + 1] = '~';
//                    str = String.valueOf(chars);
                    c = '~';
                    i++;
                } else {
                    i--; // 修补后面的数字
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

    // 转换为tree
    // 所有的叶子节点必须为数字
    // 所有非叶子节点必须为计算符
    // 当扫描遇到同优先级或者低优先级的新计算符时, 将新计算符作为新根节点, 原计算符作为左子树
    // 当扫描遇到高优先级的新计算符时, 将原右子树作为新计算符的左子树, 新计算符作为根节点的右子树
    // 扫描遇到括号时, 将整个括号中的内容做substring并递归处理
//    public TreeNode strToTree(String str) {
//        if (str.length() > 0) {
//            if (str.charAt(0) == '-') { // 去掉首负号, 将负号替换为~
//                str = '~' + str.substring(1);
//            }
//        }
//        Stack<TreeNode> stack = new Stack<>();
//        HashMap<Character, Integer> map = new HashMap<>();
//        map.put('+', 1);
//        map.put('-', 1);
//        map.put('*', 2);
//        map.put('/', 2);
//        map.put('(', 3);
//        map.put(')', 0);
//        TreeNode root = null; // root节点表示最低优先的操作符
//        TreeNode temp = null; // temp 表示最后的操作符
//        for (int i = 0; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == '+' || c == '-' || c == '*' || c == '/') {
//                if (str.charAt(i+1) == '-') { // 算术符后面的负号替换为~
//                    char[] chars = str.toCharArray();
//                    chars[i+1] = '~';
//                    str = chars.toString();
//                }
//                TreeNode node = new TreeNode(c);
//                if (root.symbol != Character.MIN_VALUE) { // 这里表示是数字节点, 此时将root作为左子树, 构造新的TreeNode作为新root节点
//                    node.left = root;
//                    root = node;
//                } else { // 这里表示root为算术符
//                    if (map.get(c) <= map.get(root.symbol)) {  // 当扫描遇到同优先级或者低优先级的新计算符时, 将新计算符作为新根节点, 原计算符作为左子树
//                        node.left = root;
//                        root = node;
//                    } else { // 当扫描遇到高优先级的新计算符时, 将原右子树作为新计算符的左子树, 新计算符作为根节点的右子树
//                        node.left = root.right;
//                        root.right = node;
//                    }
//                }
//            }
//            else if (c == '(') { // 将整个括号中的内容进行递归
//                int num = 1;
//                int end = 0;
//                for (int j = i+1; j < str.length(); j++) {
//                    if (str.charAt(j) == '(') num ++;
//                    if (str.charAt(j) == ')') num --;
//                    if (num == 0) {
//                        end = j+1;
//                        break;
//                    }
//                }
//                int val = calcuteTree(str.substring(i,end));
//                i = end;
//                TreeNode node = new TreeNode(val);
//
//            }
//            else if ((c <= '9' && c >= '0') || c == '~') {
//
//            } else if (c == ' '){
//                continue;
//            } else {
//                throw new RuntimeException("unexpected character");
//            }
//        }
//    }

    public int calcuteTree (String str) {
        return 0;
    }


//    public void getTree (String str) {
//        Stack<TreeNode> stack = new Stack<>();
//        int isHighpriority = 0;
//        TreeNode root = null;
//        int start = 0;
//        if (str.charAt(0) == '-') start = 1;
//        for (int i = start; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c <= '9' && c >= '0') {
//                continue;
//            }
//            TreeNode node = new TreeNode(Integer.valueOf(str.substring(0, i)));
//            stack.push(node);
//            start = i;
//        }
//        for (int i = start; i < str.length(); i++) {
//            char c = str.charAt(i);
//            if (c == '+' || c == '-') {
//                TreeNode node = new TreeNode(c);
//                TreeNode temp = stack.pop();
//                node.left = temp;
//                stack.push(node);
//            }
//            else if (c == '*' || c == '/') { // 如果是乘除, 则把node里面的右节点置为乘除, 并把原来的右节点设为当前的左节点
//                TreeNode temp = new TreeNode(c);
//                TreeNode node = stack.pop();
//                temp.left = node.right;
//                node.right = temp;
//
//            }
//            else if (c == '(') { // 当isHighpriority 不为0时, 说明在括号内
//                isHighpriority ++;
//            }
//            else if (c == ')') {
//                isHighpriority --;
//            }
//            else {
//                for (int j = i; j < str.length(); j++) {
//                    c = str.charAt(j);
//                    if (c <= '9' && c >= '0') {
//                        continue;
//                    }
//                    TreeNode node = null;
//                    if (j == str.length() - 1) {
//                        node = new TreeNode(Integer.valueOf(str.substring(i, j + 1)));
//                    } else {
//                        node = new TreeNode(Integer.valueOf(str.substring(i, j)));
//                    }
//                    stack.push(node);
//                }
//            }
//        }
//    }

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