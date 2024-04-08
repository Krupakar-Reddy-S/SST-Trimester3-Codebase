public class Party {

    /* 
     * You are planning a party. A person can either be individual or a couple.
     * How many ways can the people split into singles or couples?
     * 
    */

    // Iterative Approach
    // TC = O(N), SC = O(N)
    public static int solve1(int n) {
        if (n <= 1) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + (i-1) * dp[i-2];
        }

        return dp[n];
    }

    // Recursive Approach
    // TC = O(N), SC = O(N)
    

    public static void main(String[] args) {
        System.out.println(solve1(4));
    }
}
