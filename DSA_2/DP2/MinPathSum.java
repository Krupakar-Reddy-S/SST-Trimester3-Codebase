public class MinPathSum {

    // TC = O(N * M), SC = O(N * M) [Bottom-up Memoization]
    public static int minPathSum(int arr[][]) {
        int N = arr.length;
        int M = arr[0].length;

        int dp[][] = new int[N][M];

        dp[0][0] = arr[0][0];

        for (int i = 1; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
        }

        for (int j = 1; j < M; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j] = arr[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) {
        
    }
}
