public class GCD {

    /* 
     * gcd - Greatest Common Divisor (HCF)
     * 
     *      gcd(x, y) = 1 -> co-primes
     * 
     *      gcd(a, 1) = 1
     *      gcd(a, 0)  |a|
     *      gcd(a, b, c) = gcd(gcd(a, b), c)
     *      
     *      gcd(a, b) = gcd(b, a - b)
     *      gcd(a, b) = gcd(b, a%b)
     * 
    */

    // TC = O(log(N)), SC = O(1), [N = ]
    // Only works with positves, takes abs() before passing in function.
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    public static int gcdArray(int[] nums) {
        int ans = gcd(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            ans = gcd(ans, nums[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(gcd(50, 10));

        int A[] = {4, 2, 6, 8, 28, 32 };
        System.out.println(gcdArray(A));
    }
}
