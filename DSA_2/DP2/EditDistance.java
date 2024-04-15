public class EditDistance {

    /* 
     * Given 2 Strings Sa and Sb, find the minimum number of operations
     * required to convert Sa to Sb. The operations allowed are:
     * 
     * 1. Insert a character
     * 2. Delete a character
     * 3. Update a character
     * 
    */

    // TC = O(N^2), SC = O(N^2) [Recursive Approach]
    public static int editDistance1(String Sa, String Sb, int lenA, int lenB) {
        if (lenA == 0 || lenB == 0) {
            return Math.max(lenA, lenB);
        }
        

        if (Sa.charAt(lenA-1) == Sb.charAt(lenB-1)) {
            editDistance1(Sa, Sb, lenA-1, lenB-1);
        }
        else if(lenA > lenB) {
            return Math.min(1 + editDistance1(Sa, Sb, lenA-1, lenB), 1 + editDistance1(Sa, Sb, lenA, lenB-1));
        }
        else if (lenA < lenB) {
            return Math.min(1 + editDistance1(Sa, Sb, lenA-1, lenB), 1 + editDistance1(Sa, Sb, lenA, lenB-1));
        }
        else {
            return 1 + editDistance1(Sa, Sb, lenA-1, lenB-1);
        }

        return 0;
    }

    // TC = O(N^2), SC = O(N^2) [Iterative Approach]
    public static int editDistance2(String Sa, String Sb) {
        int lenA = Sa.length();
        int lenB = Sb.length();

        int[][] dp = new int[lenA+1][lenB+1];

        for (int i = 0; i <= lenA; i++) {
            for (int j = 0; j <= lenB; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                else if (j == 0) {
                    dp[i][j] = i;
                }
                else if (Sa.charAt(i-1) == Sb.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[lenA][lenB];
    }

    // TC = O(N^2), SC = O(N) [Iterative Approach with Space Optimisation]
    public static int editDistance3(String Sa, String Sb) {
        int lenA = Sa.length();
        int lenB = Sb.length();

        int[] dp = new int[lenB+1];

        for (int i = 0; i <= lenA; i++) {
            int prev = dp[0];
            for (int j = 0; j <= lenB; j++) {
                int temp = dp[j];
                if (i == 0) {
                    dp[j] = j;
                }
                else if (j == 0) {
                    dp[j] = i;
                }
                else if (Sa.charAt(i-1) == Sb.charAt(j-1)) {
                    dp[j] = prev;
                }
                else {
                    dp[j] = 1 + Math.min(dp[j], Math.min(dp[j-1], prev));
                }
                prev = temp;
            }
        }

        return dp[lenB];
    }

    public static void main(String[] args) {
        String Sa = "horse";
        String Sb = "ros";

        System.out.println(editDistance1(Sa, Sb, Sa.length(), Sb.length()));
        // System.out.println(editDistance2(Sa, Sb));
    }
}
