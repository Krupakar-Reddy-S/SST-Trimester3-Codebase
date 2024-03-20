import java.util.ArrayList;

public class NDigit12 {

    /* 
     * Generate all N digit numbers using {1, 2}
     * 
    */

    // TC = O(2^N), SC = O(N)
    public static void nDigitStr(int n, String processed) {
        if (n == 0) {
            System.out.println(processed);
            return;
        }

        nDigitStr(n-1, processed + '1');
        nDigitStr(n-1, processed + '2');
    }

    // TC = O(2^N), SC = O(N)
    public static void nDigitNum(int n, int num, ArrayList<Integer> list) {
        if (n == 0) {
            list.add(num);
            return;
        }

        nDigitNum(n-1, num*10 + 1, list);
        nDigitNum(n-1, num*10 + 2, list);
    }
    
    // TC = O(2^N), SC = O(N)
    static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Integer> nDigitNum1(int n, int num) {
        if (n == 0) {
            list1.add(num);
            return list1;
        }

        nDigitNum1(n-1, num*10 + 1);
        nDigitNum1(n-1, num*10 + 2);

        return list1;
    }

    // Verify this for correctness
    public static void nDigitNum2(ArrayList<ArrayList<Integer>> ans, int n, ArrayList<Integer> list) {
        if (list.size() == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        list.add(1);
        nDigitNum2(ans, n, list);
        list.remove(list.size()-1);
        list.add(2);
        nDigitNum2(ans, n, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        nDigitStr(3, "");

        ArrayList<Integer> list = new ArrayList<>();
        nDigitNum(3, 0, list);
        System.out.println(list);

        System.out.println(nDigitNum1(3, 0));

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        nDigitNum2(ans, 3, new ArrayList<>());
        System.out.println(ans);
    }
}
