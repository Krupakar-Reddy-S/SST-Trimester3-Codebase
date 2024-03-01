import java.util.Arrays;

public class HeapSort {

    /* 
     * Perform HeapSort on the given Array
     * 
    */

    // TC = O(NlogN); SC = O(1)
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build the Heap
        for(int i = n/2 - 1; i >= 0; i--) {
            shiftDown(arr, i, n);
        }

        // DeleteMin n times
        for(int i = 0; i < n; i++) {
            int min = arr[0];
            arr[0] = arr[n-1-i];
            arr[n-1-i] = min;

            shiftDown(arr, 0, n-1-i);
        }
    }

    // TC = O(logN); SC = O(1)
    public static void shiftDown(int A[], int i, int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;

        if (left < n && A[left] > A[i]) {
            smallest = left;
        }
        if (right < n && A[right] > A[smallest]) {
            smallest = right;
        }

        if (smallest == i) {
            return;
        }
        else {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;

            shiftDown(A, smallest, n);
        }
    }


    public static void main(String[] args) {
        int arr[] = {10, 2, 1, 3, 5, 6, 4, 9, 7};
        heapSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
