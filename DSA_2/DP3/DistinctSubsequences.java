public class DistinctSubsequences {

    /* 
     * Given 2 strings A & B,
     * Count the  No. of Unique ways in which
     * we can get B as a subsequence of A.
     * 
     * EXAMPLES:
     * 1) A = "rabbbit", B = "rabbit" -> 3`
     * 
    */

    // TC = O(2^N), SC = O(N) [Recursive Approach]
    public static int distinctSubsequences(String a, String b, int i, int j) {
        if(j == b.length()) {
            return 1;
        }
        if(i == a.length()) {
            return 0;
        }

        if(a.charAt(i) == b.charAt(j)) {
            return distinctSubsequences(a, b, i+1, j+1) + distinctSubsequences(a, b, i+1, j);
        }
        else {
            return distinctSubsequences(a, b, i+1, j);
        }
    }

    // TC = O(N^2), SC = O(N^2) [DP Approach]
    public static int distinctSubsequencesDP(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++) dp[i][0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        
    }
}
