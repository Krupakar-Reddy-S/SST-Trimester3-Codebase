public class WildCardMathing {

    /* 
     * Given 2 strings S -> word {a-z} and P -> pattern {a-z, ?, *}
     * '?' -> matches any single character
     * '*' -> matches any sequence of characters (including the empty sequence)
     * 
     * return true if the pattern matches the word
     * 
     * EXAMPLES:
     * 1) S = "abxclm", P = "a*lm" -> true
     * 2) S = "abc", P = "a?" -> false
     * 3) S = "abcdef", P = "*?" -> true
     * 4) S = "abcdef", P = "**" -> true
     * 5) S ="", P = "*****" -> true
    */

    // TC = O(N * M), SC = O(N * M) [Bottom-up Memoization]
    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;

        for(int i = 1; i <= m; i++) {
            if(p.charAt(i-1) == '*') {
                dp[0][i] = dp[0][i-1];
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {

                if(p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if(p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[n][m];
    }

    // TC = O(N * M), SC = O(N * M) [Top-down Recursion + Memoization]
    public static boolean isMatchTopDown(String s, String p) {
        int n = s.length();
        int m = p.length();

        Boolean[][] dp = new Boolean[n+1][m+1];
        return isMatchTopDown(s, p, n, m, dp);
    }

    public static boolean isMatchTopDown(String s, String p, int n, int m, Boolean[][] dp) {
        if(m == 0) {
            return n == 0;
        }

        if(n == 0) {
            return p.charAt(m-1) == '*' && isMatchTopDown(s, p, n, m-1, dp);
        }

        if(dp[n][m] != null) {
            return dp[n][m];
        }

        if(p.charAt(m-1) == s.charAt(n-1) || p.charAt(m-1) == '?') {
            return dp[n][m] = isMatchTopDown(s, p, n-1, m-1, dp);
        } else if(p.charAt(m-1) == '*') {
            return dp[n][m] = isMatchTopDown(s, p, n-1, m, dp) || isMatchTopDown(s, p, n, m-1, dp);
        }

        return dp[n][m] = false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("abxclm", "a*lm")); // true
        System.out.println(isMatch("abc", "a?")); // false
        System.out.println(isMatch("abcdef", "*?")); // true
        System.out.println(isMatch("abcdef", "**")); // true
        System.out.println(isMatch("", "*****")); // true
        System.out.println(isMatch("abcdef", "*b*")); // true
        System.out.println(isMatch("aab", "c*a*b")); // false   
    }
}
