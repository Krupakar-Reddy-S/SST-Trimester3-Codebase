public class FactorialArrayGCD {

    /*
     * Companies: Paytm
     * 
     * Given an Array of numbers,
     * calculate GCD of factorials of all values.
     * 
     */

    // O(N * log(N)), SC = O(1)
    // factorial of minimum value :)
    public static int arrayFactroialsGCD(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        return factorial(min);
    }

    public static int factorial(int num)  {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        int A[] = {5, 3, 7, 8, 10 };
        System.out.println(arrayFactroialsGCD(A));
    }
}
