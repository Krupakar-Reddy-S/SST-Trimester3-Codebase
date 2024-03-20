import java.util.ArrayList;

public class Subsequences {

    /* 
     * Generate all the sunsequences of a given array
     * 
    */

    // TC = O(2^N), SC = O(N)
    // Bit manipulation approach
    public static ArrayList<ArrayList<Integer>> subseq1(int[] list) {
        long n = (long) Math.pow(2, list.length);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int j = 0; j < list.length; j++) {
                if ((i & (1 << j)) != 0) {
                    temp.add(list[j]);
                }
            }
            ans.add(temp);
        }

        return ans;
    }

    // TC = O(2^N), SC = O(N)
    // Backtracking approach
    public static void subseq2(int[] list, int index, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> ans) {
        if (index == list.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(list[index]);
        subseq2(list, index+1, temp, ans);
        temp.remove(temp.size()-1);
        subseq2(list, index+1, temp, ans);
    }

    public static void main(String[] args) {
        int A1[] = {1, 2, 3};
        System.out.println(subseq1(A1));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subseq2(A1, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }
}
