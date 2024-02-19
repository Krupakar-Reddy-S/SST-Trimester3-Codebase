public class CountCompleteNodes {

    /* 
     * Given a complete binary tree, A, find the total number of nodes in the tree.
     * 
    */

    public int countNodes(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int left = countNodes(A.left);
        int right = countNodes(A.right);
        
        return left + right + 1;
    }

    public static void main(String[] args) {
        
    }
}
