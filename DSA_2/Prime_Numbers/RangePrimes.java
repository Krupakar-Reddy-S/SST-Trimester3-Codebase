public class RangePrimes {

    /* 
     * Given a No, N,
     * Generate all primes till N.
     * 
    */

    // TC = O(N * sqrt(N)), SC = O(N);
    public static boolean[] rangePrimes1(int N) {
        boolean primes[] = new boolean[N+1];
        long start = System.currentTimeMillis();

        for (int i = 1; i <= N; i += 2) {
            if (isPrime(i)) {
                primes[i] = true;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("For N: " + N + ", Time taken: " + (end - start) + "ms");
        return primes;
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
    
    // TC = O(N * log(log(N))), SC = O(N) [Sieve of Eratosthenes]
    // Since log(log(N)) is very small, it is almost constant time.
    // Hence the approximate TC ~ O(N)
    public static boolean[] rangePrimes2(int N) {
        boolean primes[] = new boolean[N+1];
        long start = System.currentTimeMillis();

        for (int i = 0; i <= N; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i <= N; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= N; j += i) {
                    primes[j] = false;
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("For N: " + N + ", Time taken: " + (end - start) + "ms");
        return primes;
    }

    // This can be extended to generate within different ranges and sizes without limits.
    // Sieve of Atkin TC = O(N) 

    public static void main(String[] args) {
        boolean primes1[] = rangePrimes2(1000000000);
        System.out.println(primes1);

        // for (int i = 2; i < primes1.length; i++) {
        //     if (primes1[i]) {
        //         System.out.println(i);
        //     }
        // }
    }
}
