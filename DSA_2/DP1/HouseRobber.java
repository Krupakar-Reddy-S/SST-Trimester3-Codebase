public class HouseRobber {

    /* 
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, 
     * the only constraint stopping you from robbing each of them is that 
     * adjacent houses have security system connected and it will automatically contact 
     * the police if two adjacent houses were broken into on the same night. 
     * 
     * Given a list of non-negative integers representing the amount of money of each house,
     * determine the maximum amount of money you can rob tonight without alerting the police.
     * 
    */

    // TC = O(N), SC = O(N)
    public static int solve1(int[] nums) {
        int n = nums.length;

        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int dp[] = new int[n+1];
        
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int arr[] = {10, 2,  3, 16, 2 };
        System.out.println(solve1(arr));
    }
}
