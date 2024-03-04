import java.util.ArrayList;
import java.util.Arrays;

public class QueryPrimeFactors {

    // TC = 
    public static ArrayList<ArrayList<Integer>> PrimeFactorsQuery(ArrayList<Integer> queries, int N) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        boolean primes[] = new boolean[N+1];

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

        for (Integer num : queries) {
            ArrayList<Integer> factors = new ArrayList<>();

            if (primes[num]) {
                factors.add(num);
                ans.add(factors);
                continue;
            }
            else {
                int n = num;
        
                for (int i = 2; i * i <= num; i++) {
                    if (n == 1) {
                        break;
                    }

                    if (n % i == 0) {
                        while (n % i == 0) {
                            n /= i;
                            factors.add(i);
                        }
                    }
                }

                if (n > 1) {
                    factors.add(N);
                }

                ans.add(factors);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> queries = new ArrayList<>(Arrays.asList(1000000000, 1000000000, 1000000000, 1000000000, 1000000000));
        ArrayList<ArrayList<Integer>> ans = PrimeFactorsQuery(queries, 1000000000);

        System.out.println(ans);
    }
}
