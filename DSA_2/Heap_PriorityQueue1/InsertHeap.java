public class InsertHeap {

    /* 
     * Insert the given element in the correct place in the Heap
     * 
    */

    // TC = O(logN); SC = O(1)
    public static void insert(Heap heap, int key) {
        int n = heap.size;
        if (n == heap.A.length) {
            int[] B = new int[2*n];
            for(int i = 0; i < n; i++) {
                B[i] = heap.A[i];
            }

            Heap heapB = new Heap(2*n);
            heapB.A = B;

            heap = heapB;
        }

        heap.size = n+1;
        heap.A[n] = key;

        shiftUp(heap.A, n);
    }

    // TC = O(logN); SC = O(1)
    public static void shiftUp(int A[], int i) {
        int parent = (i-1)/2;

        if (parent >= 0 && A[parent] > A[i]) {
            int temp = A[i];
            A[i] = A[parent];
            A[parent] = temp;

            shiftUp(A, parent);
        }
    }


    public static void main(String[] args) {
        int arr[] = {2, 1, 3, 5, 6, 4, 7, 10 };
        Heap heap = new Heap(arr.length);
        heap.A = arr;

        System.out.println(heap);
        insert(heap, 0);
        System.out.println(heap);
    }
}
