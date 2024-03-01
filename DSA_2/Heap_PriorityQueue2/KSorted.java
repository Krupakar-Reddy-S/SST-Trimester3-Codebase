import java.util.Arrays;
import java.util.PriorityQueue;

public class KSorted {

    /* 
     * Given a K-Sorted Array. Sort the Array
     * 
    */

    // TC = O(NlogK); SC = O(K)
    public static void kSorted(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= k; i++) {
            pq.add(arr[i]);
        }

        int index = 0;
        for(int i = k+1; i < arr.length; i++) {
            arr[index++] = pq.remove();
            pq.add(arr[i]);
        }

        while(pq.size() > 0) {
            arr[index++] = pq.remove();
        }
    }

    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        System.out.println(Arrays.toString(arr));
        kSorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
