public class ArrayNumMod {


    /* 
     * Companies: Google
     * 
     * Given an Array representig a number A,
     * And a number N, Return the number A % N
     * 
     *      |A| <= 10^5
     *      0 <= A[i] <= 9
     *      1 <= N <= 10^9
     * 
    */

    // TC = O(N), SC = O(1) [N = Number of digits in the number]
    // But this wont work for large numbers, as given N <= 10^5
    public static int solve1(int[] nums, int N) {
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            num *= 10;
            num += nums[i];
        }

        return num % N;
    }

    // TC = O(N), SC = O(1) [N = Number of digits in the number]
    public static int solve2(int[] nums, int N) {
        int num = 0;

        for (int i = 0; i < nums.length; i++) {
            num = (num * 10 + nums[i]) % N;
        }

        return num;
    }


    public static void main(String[] args) {
        int A[] = {1, 2, 3, 8, 9 };
        int N = 69;

        System.out.println(solve2(A, N));
    }
}