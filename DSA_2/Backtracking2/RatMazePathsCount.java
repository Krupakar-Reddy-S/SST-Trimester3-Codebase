public class RatMazePathsCount {

    /* 
     * Given:
     *      - Start point of the rat(ri, rj)
     *      - End point of the rat(endi, endj)
     *      - Cells with cheese (A[i][j] = 0)
     *      - blocked cells (A[i][j] = 1)
     *      - empty cells (A[i][j] = 2)
     * 
     * Count No. of paths from start to end, if rat can move in all 4 directions
     * such that the rat can eat all the cheese in the maze.
     * 
    */

    public static int countPaths(int[][] A, int ri, int rj, int endi, int endj) {
        return countPaths(A, ri, rj, endi, endj, new boolean[A.length][A[0].length]);
    }

    public static int countPaths(int[][] A, int ri, int rj, int endi, int endj, boolean[][] visited) {
        if (ri < 0 || rj < 0 || ri >= A.length || rj >= A[0].length || A[ri][rj] == 1 || visited[ri][rj]) {
            return 0;
        }

        if (ri == endi && rj == endj) {
            return 1;
        }

        visited[ri][rj] = true;
        int count = 0;

        count += countPaths(A, ri + 1, rj, endi, endj, visited);
        count += countPaths(A, ri - 1, rj, endi, endj, visited);
        count += countPaths(A, ri, rj + 1, endi, endj, visited);
        count += countPaths(A, ri, rj - 1, endi, endj, visited);

        visited[ri][rj] = false;

        return count;
    }

    public static void main(String[] args) {
        int A[][] = { { 2, 0, 1, 2 }, 
                      { 2, 2, 0, 2 }, 
                      { 0, 2, 2, 2 }, 
                      { 2, 0, 1, 2 }  };

        System.out.println(countPaths(A, 0, 0, 3, 3));
    }
}
