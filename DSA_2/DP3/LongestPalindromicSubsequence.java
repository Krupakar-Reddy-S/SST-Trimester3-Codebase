public class LongestPalindromicSubsequence {
    
    /* 
     * LPS (Longest palindromic Subsequence)
     * Given a string, return the length of LPS
     * 
     * EXAMPLES:
     * 1) S = "agbdba" -> 5 {"abdba"}
     * 2) S = "acbacb" -> 3 {"aca", "cac", "bab", ...}
     * 
    */

    // TC = O(2^N), SC = O(N) [Recursive Approach]
    public static int lps(String s, int i, int j) {
        if(i == j) {
            return 1;
        }
        if(s.charAt(i) == s.charAt(j) && i+1 == j) {
            return 2;
        }
        if(s.charAt(i) == s.charAt(j)) {
            return lps(s, i+1, j-1) + 2;
        }

        return Math.max(lps(s, i+1, j), lps(s, i, j-1));
    }

    // TC = O(N^2), SC = O(N^2) [DP Approach]
    public static int lpsDP(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) dp[i][i] = 1;

        for(int len = 2; len <= n; len++) {
            for(int i = 0; i < n-len+1; i++) {
                int j = i+len-1;

                if(s.charAt(i) == s.charAt(j) && len == 2) {
                    dp[i][j] = 2;
                }
                else if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }

    public static void main(String[] args) {
        String s = "agbdba";
        System.out.println(lpsDP(s));
    }
}
