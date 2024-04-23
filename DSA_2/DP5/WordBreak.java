import java.util.List;

public class WordBreak {

    /* 
     * Given a string S and a dictionary of strings WordDict, 
     * return true if S can be segmented into a space-separated sequence of one or more dictionary words.
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     * 
    */

    // TC = O(N^2), SC = O(N) [DP Approach]
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int len = word.length();
                if (i >= len && s.substring(i-len, i).equals(word)) {
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");

        System.out.println(wordBreak(s, wordDict)); // false
    }
}
