public class Game {

    /* 
     * 
     * 
    */

    public static int game(int[] nums) {
        int ans = gcd(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            ans = gcd(ans, nums[i]);
        }

        return ans;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int A[] = {2, 5, 10, 20, 40, 50};
        System.out.println(game(A));
    }
}
