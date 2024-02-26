public class MaximumXORSubArray {

    /* 
     * Given an Array of integers, find the subarray with maximum XOR.
     * 
    */

    // TC = O(N^3), SC = O(1) [N = no. of elements in the array]
    public static int maxXORSubarray1(int[] arr) {
        int maxXOR = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xor = 0;
                for (int k = i; k <= j; k++) {
                    xor ^= arr[i];
                }

                maxXOR = Math.max(maxXOR, xor);
            }
        }

        return maxXOR;
    }

    // XOR(L-R) = XPS[R] ^ XPS[L-1]
    // public static int maxXORSubarray2(int[] arr) {
    //     int maxXor = Integer.MIN_VALUE;
    //     int prefixXOR[] = new int[arr.length];
    //     prefixXOR[0] = arr[0];

    //     for (int i = 1; i < arr.length; i++) {
    //         prefixXOR[i] = prefixXOR[i-1] ^ arr[i];
    //     }

        
    // }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        System.out.println(maxXORSubarray1(arr));
    }
}
