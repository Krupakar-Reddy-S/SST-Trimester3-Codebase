import java.util.Arrays;

public class Fibonacci {

    // Vanilla Recursion -> Wasted Compute
    // TC = O(2^N), SC = O(N)
    public static int fib1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fib1(n-1) + fib1(n-2);
    }

    // Using Memoization -> saving the return value of a function call to be used later

    // Bottom Up DP
    // TC = O(N), SC = O(N)
    public static int fib2(int n) {
        int fibs[] = new int[n+1];
        fibs[0] = 0;
        fibs[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }

        return fibs[n];
    }

    // Top Down DP
    // TC = O(N), SC = O(N)
    public static int fib3(int n, int[] fibs) {
        if (fibs[n] == -1) {
            if (n <= 1) {
                fibs[n] = n;
            }
            else {
                fibs[n] = fib3(n-1, fibs) + fib3(n-2, fibs);
            }
        }

        return fibs[n];
    }

    // TC = O(N), SC = O(1)
    public static int fib4(int n) {
        int a = 0, b = 1, c = 0;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return c;
    }

    // These functions show that when we write DP Solutions,
    // It is better to write it iteratively rather than recursively,
    // as it is space optimized and less prone to stack overflow errors

    public static void main(String[] args) {
        int n = 45;

        long start1 = System.currentTimeMillis();
        System.out.print(fib1(n));
        long end1 = System.currentTimeMillis();

        System.out.println(" , time: " + (end1 - start1) + "ms");

        long start2 = System.currentTimeMillis();
        System.out.print(fib2(n));
        long end2 = System.currentTimeMillis();

        System.out.println(" , time: " + (end2 - start2) + "ms");

        int fibs[] = new int[n+1];
        Arrays.fill(fibs, -1);

        long start3 = System.currentTimeMillis();
        System.out.print(fib3(n, fibs));
        long end3 = System.currentTimeMillis();
        
        System.out.println(" , time: " + (end3 - start3) + "ms");
        // System.out.println(Arrays.toString(fibs));

        long start4 = System.currentTimeMillis();
        System.out.print(fib4(n));
        long end4 = System.currentTimeMillis();

        System.out.println(" , time: " + (end4 - start4) + "ms");
    }
}