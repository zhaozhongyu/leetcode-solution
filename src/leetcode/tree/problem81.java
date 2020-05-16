package leetcode.tree;

public class problem81 {

    // 最小值, 最大值在中间
    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == target)
                return true;
        return false;
    }

//    public static void main(String[] args) {
//        int [] nums= new int[]{1,1,1,3,1};
//        System.out.print(new problem81().search(nums, 3));
//    }

    public static boolean binary(int[] array, int value, int low, int high)
    {
        while(low <= high)
        {
            int middle = (low + high) / 2;
            if(value == array[middle])
            {
                return true;
            }
            if(value > array[middle])
            {
                low = middle + 1;
            }
            if(value < array[middle])
            {
                high = middle - 1;
            }
        }
        return false;
    }
}
