import java.util.ArrayList;

public class GenerateValidParanthesis {

    /* 
     * Given a number N,
     * generate all valid paranthesis using N pairs
     * 
    */

    public static ArrayList<String> generateParanthesis(int N) {
        ArrayList<String> ans = new ArrayList<>();
        generateParanthesis(N, ans, new StringBuilder(), 0, 0);

        return ans;
    }

    public static void generateParanthesis(int N, ArrayList<String> ans, StringBuilder sb, int open, int close) {
        if (sb.length() == 2 * N) {
            ans.add(sb.toString());
            return;
        }

        if (open < N) {
            sb.append("(");
            generateParanthesis(N, ans, sb, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(")");
            generateParanthesis(N, ans, sb, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> ans = generateParanthesis(3);

        for (String s : ans) {
            System.out.println(s);
        }
    }
}
