class Solution {
    public int[] sortArrayByParity(int[] A) {
        int low = 0, high = A.length - 1, temp;
        while(low < high) {
            if (A[low] % 2 == 0) {
                low++;
            }
            if (A[high] % 2 != 0) {
                high--;
            }
            if (A[low] % 2 != 0 && A[high] % 2 == 0 && low < high) {
                temp = A[low];
                A[low++] = A[high];
                A[high--] = temp;
            }
        }
        return A;
    }
}
