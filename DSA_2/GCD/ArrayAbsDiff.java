import java.util.ArrayList;
import java.util.Arrays;

public class ArrayAbsDiff {

    /* 
     * Given an array of +ve numbers.
     * You can pick any two numbers, 
     * Add the absolute difference to the 
     * array if not already present.
     * 
     * Determine the max size arrray can achieve.
     * 
    */

    // 
    public static int arrayAbsDiff(ArrayList<Integer> list) {
        int GCD = 0;
        int max = 0;

        for (int num : list) {
            GCD = gcd(GCD, num);
            max = Math.max(max, num);
        }

        return max / GCD;
        
        // HashSet<Integer> set = new HashSet();

        // for (int i = GCD; i <= max; i+=GCD) {
        //     set.add(i);
        // }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }


    public static void main(String[] args) {
        ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(2, 10));
        System.out.println(arrayAbsDiff(A1));
    }
}
