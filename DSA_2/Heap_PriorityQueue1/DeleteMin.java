public class DeleteMin {

    /* 
     * DeleteMin(A[])
     * 
    */


    // TC = O(N); SC = O(N)
    public static int deleteMin(Heap heap) {
        int n = heap.size;

        int min = heap.A[0];
        heap.A[0] = heap.A[n-1];
        heap.size = n-1;
        heap.size = n-1;

        shiftDown(heap.A, 0, n-1);

        return min;
    }   

    // TC = O(logN); SC = O(1)
    public static void shiftDown(int A[], int i, int n) {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int smallest = i;

        if (left < n && A[left] < A[i]) {
            smallest = left;
        }
        if (right < n && A[right] < A[smallest]) {
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
        Heap heap = new Heap(9);
        heap.A = new int[]{-1, 2, 1, 3, 5, 6, 4, 7, 10 };

        deleteMin(heap);
        System.out.println(heap);
    }
}
