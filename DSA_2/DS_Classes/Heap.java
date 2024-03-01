public class Heap {
    int A[];
    int size;

    public Heap(int n) {
        this.A = new int[n];
        size = n;
    }

    public String toString() {
        int iMax = size - 1;
        if (iMax < 0) {
            return "[]";
        }

        if (iMax > A.length - 1) {
            throw new IndexOutOfBoundsException("Heap size is greater than array size, " + iMax + " > " + A.length);
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = 0; ; i++) {
            sb.append(A[i]);

            if (i == iMax) {
                return sb.append(']').toString();
            }

            sb.append(", ");
        }
    }
}
