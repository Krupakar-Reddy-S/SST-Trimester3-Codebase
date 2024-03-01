public class CountDistinctBinary {

    /* 
     * Given a 2D matrix of 1s and 0s,
     * Count the No. of distinct rows in the matrix.
     * 
    */

    // TC = O(N * M), SC = O(N * M) [N = no. of rows, M = no. of columns]
    public static int countDistinctRows(int[][] matrix) {
        Trie root = new Trie();
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {

            StringBuilder row = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                row.append(matrix[i][j]);
            }

            if (!root.search(row.toString())) {
                root.insert(row.toString());
                count++;
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int binaryMatrix[][] = { { 1, 0, 0, 1, 0 },
                                 { 0, 1, 0, 1, 0 }, 
                                 { 1, 1, 0, 1, 1 }, 
                                 { 1, 1, 0, 0, 1 }, 
                                 { 1, 1, 0, 1, 1 }, 
                                 { 1, 0, 0, 1, 0 }, 
                                 { 1, 0, 1, 0, 1 }, 
                                 { 0, 0, 1, 1, 0 } };

        System.out.println(countDistinctRows(binaryMatrix)); // 6
    }
}
