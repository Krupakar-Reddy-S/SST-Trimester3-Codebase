public class ClimbStairs {

    /* 
     * Given N stairs, you can climb either 1 or 2 stairs at a time.
     * In how many distinct ways can you climb to the top?
     * 
    */

    // TC = O(N), SC = O(N)
    public static int solve1(int n) {
        if (n <= 1) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // TC = O(N), SC = O(1)
    public static int solve2(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 1, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    public static void main(String[] args) {
        System.out.println(solve2(4));
    }
}
