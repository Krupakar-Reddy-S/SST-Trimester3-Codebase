public class MinKSubsequence {

    /* 
     * Given an Array,  find the Min Sum of Subsequence of size K
     * 
    */

    public static int minKSubsequence(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        if (k == 0) {
            return sum;
        }

        int ans = 0;
        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = 0; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            ans += min;
            arr[minIndex] = Integer.MAX_VALUE;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, -1, 10, 6, 3, 8, 9 };

        int ans = minKSubsequence(arr, 4);
        System.out.println(ans);
    }
}