public class CountPaths {

    /* 
     * Given a N X M matrix with your initial position at the top-left cell, 
     * find the number of possible unique paths to reach the bottom-right cell 
     * of the matrix from the initial position. Given that you can only move
     * right or down.
     * 
    */

    // TC = O(2^(N + M)), SC = O(N + M) 
    public static int countPaths1(int N, int M) {
        if (N == 1 || M == 1) {
            return 1;
        }

        return countPaths1(N - 1, M) + countPaths1(N, M - 1);
    }

    // TC = O(N * M), SC = O(N * M)
    public static int countPaths2(int N, int M) {
        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < M; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[N - 1][M - 1];
    }

    // TC = O(N * M), SC = O(N * M) [with blocks at certain cells]
    public static int countPaths3(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;

        int[][] dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            if (grid[i][0] == 1) {
                break;
            }

            dp[i][0] = 1;
        }

        for (int i = 0; i < M; i++) {
            if (grid[0][i] == 1) {
                break;
            }

            dp[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPaths1(3, 3));
        System.out.println(countPaths2(3, 3));

        int[][] grid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        System.out.println(countPaths3(grid));
    }
}
