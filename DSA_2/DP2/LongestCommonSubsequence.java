public class LongestCommonSubsequence {

    // TC = O(2^(N + M)), SC = O(N + M) [Brute Force Recursion]
    public static int lcs1(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) {
            return 0;
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + lcs1(s1, s2, i + 1, j + 1);
        }

        return Math.max(lcs1(s1, s2, i + 1, j), lcs1(s1, s2, i, j + 1));
    }

    // TC = O(N * M), SC = O(N * M) [Bottom-up Memoization]
    public static int lcs2(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();

        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[N][M];
    }

    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs1(s1, s2, 0, 0));
        System.out.println(lcs2(s1, s2));   
    }
}
