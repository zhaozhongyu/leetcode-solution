package leetcode.swordToOffer;

public class problem58 {

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i ++) {
            if (strs[strs.length - i - 1].equals("")) {
                continue;
            }
            sb.append(strs[strs.length - i - 1]);
            if (i != strs.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    public static void main(String[] ar) {
        new problem58().reverseWords("a good   example");
    }
}
