import java.util.HashSet;

public class SubseqGCD {

    /* 
     * Given an Array, return true if there exists a subsequence with GCD = 1.
     * 
     * 
    */

    // TC = O(), SC = O()
    public static boolean hasOneGCDSubsequence1(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int num = nums[0];

        for (int i = 2; i * i <= nums[0]; i++) {
            if (num == 1) {
                break;
            }

            if(isPrime(i)) {
                if (num % i == 0) {
                    set.add(i);

                    while (num % i == 0) {
                        num /= i;
                    }
                }
            }
        }
        
        if (num > 1) {
            set.add(num);
        }

        for (int i = 1; i < nums.length; i++) {
            if (set.size() == 0) {
                return false;
            }

            for (int factor : set) {
                if (nums[i] % factor != 0) {
                    set.remove(factor);
                }
            }
        }

        if (set.size() == 0) {
            return false;
        }

        return true;
    }

    public static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }

    public static boolean hasOneGCDSubsequence2(int[] nums) {
        int ans = gcd(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            ans = gcd(ans, nums[i]);
        }

        return ans == 1 ? true : false;
    }

    public static void main(String[] args) {
        int A1[] = {46, 34, 49, 81 };
        int A2[] = {14, 21, 28, 7 };

        System.out.println(hasOneGCDSubsequence2(A1));
        System.out.println(hasOneGCDSubsequence2(A2));
    }
}
