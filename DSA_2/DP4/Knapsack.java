import java.util.Arrays;

public class Knapsack {

    /*
     * 0/1 Knapsack Problem -> can pick once or not pick at all
     * 
     * Given N items each with a weight & a value.
     * Find the max value that can be obtained by picking
     * items such that total weight <= max capacity of sack(K)
     * 
     * -> Every item can be picked at max once
     * -> Taking an item partially is not allowed
     * 
     * EXAMPLE:
     * 
     * 1)
     * K = 50
     * w[] : [20, 10, 30, 40]
     * v[] : [100, 60, 120, 150]
     * 
     * -> 100 + 120 -> 220
     * 
     * 2)
     * K = 8
     * w[] : [3, 6, 5, 2, 4]
     * v[] : [12, 20, 15, 6, 10]
     * 
     * -> 12 + 15 -> 27
     * 
    */

    // TC = O(2^N), SC = O(N) [Recursive Approach]
    public static int solve1(int w[], int v[], int index, int K) {
        if (index == w.length || K == 0) {
            return 0;
        }

        if (w[index] > K) {
            return solve1(w, v, index+1, K+1);
        }

        return Math.max(solve1(w, v, index+1, K), v[index] + solve1(w, v, index+1, K - w[index]));
    }

    // TC = O(N*K), SC = O(N*K) [DP Approach]
    public static int solve2(int w[], int v[], int K) {
        int n = w.length;
        int dp[][] = new int[n+1][K+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= K; j++) {
                if (w[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], v[i-1] + dp[i-1][j - w[i-1]]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n][K];
    }

    // 0/infinite Knapsack Problem -> can pick multiple times
    public static int solve3(int w[], int v[], int K) {
        int n = w.length;
        int dp[] = new int[K+1];

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < n; j++) {
                if (w[j] <= i) {
                    dp[i] = Math.max(dp[i], v[j] + dp[i - w[j]]);
                }
            }
        }

        return dp[K];
    }

    public static void main(String[] args) {
        int w1[] = {20, 10, 30, 40};
        int v1[] = {100, 60, 120, 150};

        int w2[] =  {3, 6, 5, 2, 4};
        int v2[] = {12, 20, 15, 6, 10};

        System.out.println(solve1(w1, v1, 0, 50)); // 220
        System.out.println(solve2(w2, v2, 8)); // 27
        System.out.println(solve3(w2, v2, 8)); // 30    
    }
}
