import java.util.Arrays;
import java.util.PriorityQueue;

public class KSmallet {

    /* 
     * Given an Array, return K smallest elements
     * 
    */
    
    // TC = O(K + (N-K)logK) => O(K) + O(NlogK)
    public static int[] kSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++) {
            if(arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        // System.out.println(pq);

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.remove();
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {7, 2, 9, 1, 10, 3, 5, 8, 12, 50};
        int k = 5;

        int[] ans = kSmallest(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}
