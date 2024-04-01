public class RatInAMaze {

    /* 
     * Given:
     *      - a 2d matrix with 0s and 1s
     *      - 0 -> empty cell, 1 -> blocked cell, 2 -> cheese cell (only one)
     *      - position of rat(x, y)
     *      - position of cheese(a, b)
     * 
     * return true if there exists a path from rat to the cheese.
    */
    // Once visited a cell block it with 0, inplace
    public static boolean ratInAMaze(int[][] A, int x, int y, int a, int b) {
        if (x < 0 || y < 0 || x >= A.length || y >= A[0].length || A[x][y] == 1) {
            return false;
        }

        if (x == a && y == b) {
            return true;
        }

        A[x][y] = 1;

        if (ratInAMaze(A, x + 1, y, a, b) || ratInAMaze(A, x - 1, y, a, b) || ratInAMaze(A, x, y + 1, a, b) || ratInAMaze(A, x, y - 1, a, b)) {
            return true;
        }

        A[x][y] = 0;

        return false;
    }

    public static void main(String[] args) {
        int A[][] = { { 0, 0, 1, 0 }, 
                      { 1, 0, 0, 1 }, 
                      { 0, 1, 2, 0 }, 
                      { 0, 0, 1, 1 }  };
        
        System.out.println(ratInAMaze(A, 0, 0, 3, 3));
    }
}
