public class isPrime {

    /* 
     * Given a number N, find it it is prime
     * 
    */
    
    // TC = O(N), SC = O(1) [N = input num]
    public static boolean isPrime1(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }


    // TC = O(sqrt(N)), SC = O(1) [N = input num]
    public static boolean isPrime2(int num) {
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

    public static void main(String[] args) {
        int num1 = 243479;

        System.out.println(isPrime1(num1));
        System.out.println(isPrime2(num1));
    }
}
