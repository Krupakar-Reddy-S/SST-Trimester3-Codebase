public class CountCompleteNodes {

    /* 
     * Given a complete binary tree, A, find the total number of nodes in the tree.
     * 
    */

    // TC = O(N), SC = O(logN)
    public static int countNodes1(TreeNode A) {
        if (A == null) {
            return 0;
        }

        int left = countNodes1(A.left);
        int right = countNodes1(A.right);
        
        return left + right + 1;
    }

    // TC = O(logN * logN), SC = O(logN)
    public static int countNodes2(TreeNode A) {
        TreeNode left = A;
        TreeNode right = A;

        int leftHeight = 0;
        int rightHeight = 0;

        while (left != null) {
            leftHeight++;
            left = left.left;
        }

        while (right != null) {
            rightHeight++;
            right = right.right;
        }

        if (leftHeight == rightHeight) {
            return (int) Math.pow(2, leftHeight) - 1;
        }

        return 1 + countNodes2(A.left) + countNodes2(A.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(root);
        int count = countNodes2(root);
        System.out.println("Total nodes: " + count);
    }
}
