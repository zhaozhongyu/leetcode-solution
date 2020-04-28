package nowcoder.jianzhioffer;
/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * */

public class erweishuzu {
    public boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            if (binarySearch(target, array[i], 0, array[i].length-1)) return true;
        }
        return false;
    }

    public static boolean binarySearch(int target, int[] array, int left, int right) {
        if (array.length == 0) return false;
        if (left > right) return false;
        int mid = right + left >>>1;
        if (array[mid] == target) {
            return true;
        }
        if (array[mid] < target) {
            return binarySearch(target, array, mid + 1, right);
        } else {
            return binarySearch(target, array, left, mid - 1);
        }
    }
}
