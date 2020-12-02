package leetcode.swordToOffer;

public class problem40 {

    /**
     * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：arr = [3,2,1], k = 2
     * 输出：[1,2] 或者 [2,1]
     * 示例 2：
     *
     * 输入：arr = [0,1,2,1], k = 1
     * 输出：[0]
     * */
    public int[] getLeastNumbers(int[] arr, int k) {
        qsort(arr, 0, arr.length - 1, k);
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = arr[i];
        }
        return nums;
    }

    // 只排前k个值的快排
    public static int[] qsort(int arr[], int start, int end, int k) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        while (i<j) {
            while ((i<j)&&(arr[j]>pivot)) {
                j--;
            }
            while ((i<j)&&(arr[i]<pivot)) {
                i++;
            }
            if ((arr[i]==arr[j])&&(i<j)) {
                i++;
            } else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        if (i - 1 > start && i - 1 >= k) qsort(arr, start,i-1, k);
        if (j + 1 < end && j + 1 <= k) qsort(arr,j+1, end, k);
        return (arr);
    }

    public static void  main(String[] arr) {
        int[] nums = new int[]{0,0,1,2,4,2,2,3,1,4};
        new problem40().getLeastNumbers(nums, 8);
    }
}
