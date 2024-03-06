import java.util.Arrays;

public class Questions {

    public static boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        for (long i = 2L; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        // -30 % 7 -> -30 + 7 * 5 -> -30 + 35 -> 5
        System.out.println(-30 % 7); // -2
        // To get the correct we have to add the divisor to the remainder -> -2 + 7 -> 5 

        // 1. Giveen 1000 balls

        // 2. Given an array representing a large Prime No, return (P^2 - 1) % 24. (|A| <= 10^5)
        System.out.println(isPrime(Integer.MAX_VALUE)); // true

        long largePrime = Integer.MAX_VALUE;
        System.out.println( ((largePrime * largePrime) - 1) % 24); // 0

        // (P^2 - 1^2) % 24 -> (P - 1) * (P + 1) % 24 -> Always 0

        // (Amazon) 3. Given two No. N & M (N > M), Find the count of numbers (A > 0)
        // such that N % A = M % A

        // Brute Force Approach: Iterate and check if N % A == M % A
        // TC = O(N)
        int N = 10, M = 4;
        int count = 0;

        for (int A = 1; A <= N; A++) {
            if (N % A == M % A) {
                count++;
            }
        }
        System.out.println(count);

        // Optimized Approach: N % A = M % A -> N - M = A * K -> A <= N - M 
        // TC = O(N - M)
        count = 0;
        for (int A = 1; A <= N - M; A++) {
            if (N % A == M % A) {
                count++;
            }
        }
        System.out.println(count);
        
        // 4. Given a array of N elements, Find the count of pairs (i, j)
        // such that (A[i] + A[j]) % M == 0, (i, j) is same as (j, i)
        int nums[] = new int[] { 10, 19, 15, 13, 16, 26, 7, 5, 11, 12, 21 }; // Expected: 4
        int MOD = 10;
        int mods[] = new int[MOD];

        for (int i = 0; i < nums.length; i++) {
            int mod = nums[i] % MOD;
            mods[mod] = mods[mod] + 1;
        }
        System.out.println(Arrays.toString(mods));

        long ans = 0;
        ans += (mods[0] * (mods[0] - 1)) / 2; // nc2 for index 0
        // use two pointers to do nc1*mc1 and add it to ans
        int i = 1, j = MOD - 1;

        while (i <= j) {
            if (i == j) {
                ans += (mods[i] * (mods[i] - 1)) / 2;
            } 
            else {
                ans += mods[i] * mods[j];
            }

            i++;
            j--;
        }

        System.out.println(ans);

        // Given an array of size N, Return true if there exists a subarray
        // with sum divisible by N, Sum[L-R] % N == 0
    }
}