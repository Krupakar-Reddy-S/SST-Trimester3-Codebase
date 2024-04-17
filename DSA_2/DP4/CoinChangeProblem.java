public class CoinChangeProblem {

    /* 
     * Given an array of coins and a sum.
     * Find the number of ways to make the sum using the coins.
     * you can use a coin any number of times.
     * 
     * EXAMPLE:
     * 
     * 1) [1, 2, 3], sum = 4 -> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
     * 
    */

    // TC = O(2^N), SC = O(N) [Recursive Approach]
    public static int solve1(int coins[], int index, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (index == coins.length) {
            return 0;
        }

        int count1 = 0;
        if (coins[index] <= sum) {
            count1 = solve1(coins, index, sum - coins[index]);
        }

        int count2 = solve1(coins, index+1, sum);

        return count1 + count2;
    }

    // TC = O(N*sum), SC = O(N*sum) [DP Approach]
    public static int solve2(int coins[], int sum) {
        int n = coins.length;
        int dp[][] = new int[n+1][sum+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int coins[] = {1, 2, 3};    
        int sum = 4;

        System.out.println(solve2(coins, sum)); 
    }
}
