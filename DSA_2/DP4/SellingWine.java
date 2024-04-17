public class SellingWine {

    /*
     * Given N wines. Each Year you can sell either the left most or the right most wine bottle.
     * Given that the price of wine increases over time (Pi * years).
     * Calculate max profit from selling all wines.
     * 
     * EXAMPLES:
     * 1) [2, 4, 6, 2, 5] -> 64 (2*1 + 5*2 + 2*3 + 4*4 + 6*5)
     * 
    */

    static int ans = 0;

    // TC = O(2^N), SC = O(N) [Recursive Approach]
    public static void solve1(int arr[], int start, int end, int years, int sum) {
        if (start == end) {
            sum += arr[start] * years;
            ans = Math.max(ans, sum);
            return;
        }

        solve1(arr, start+1, end, years+1, sum + (arr[start] * years));
        solve1(arr, start, end-1, years+1, sum + (arr[end] * years));
    }

    public static void main(String[] args) {
        int arr[] = {2, 4, 6, 2, 5 };
        solve1(arr, 0, arr.length-1, 1, 0);

        System.out.println(ans);
    }
}
