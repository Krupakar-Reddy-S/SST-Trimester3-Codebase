import java.util.ArrayList;

public class primeFactors {

    // TC = O(sqrt(N)), SC = O(1) [N = input num]
    public static ArrayList<Integer> primeFactors1(int N) {
        ArrayList<Integer> factors = new ArrayList<>();
        int num = N;
        
        for (int i = 2; i * i <= num; i++) {
            if (N == 1) {
                break;
            }

            if (N % i == 0) {
                while (N % i == 0) {
                    N /= i;
                    factors.add(i);
                }
            }
        }

        if (N > 1) {
            factors.add(N);
        }

        return factors;
    }

    public static void main(String[] args) {
        int N = 1000000000;

        long start = System.currentTimeMillis();
        System.out.println(primeFactors1(N));
        long end = System.currentTimeMillis();

        System.out.println("Time taken: " + (end - start) + "ms");
    }
}
