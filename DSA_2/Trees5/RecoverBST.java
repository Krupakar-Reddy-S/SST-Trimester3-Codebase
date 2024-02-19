public class RecoverBST {

    /* 
     * Two elements of a Binary Search Tree (BST), represented by root A are swapped by mistake. 
     * Tell us the 2 values, when swapped, will restore the Binary Search Tree (BST). 
     * A solution using O(n) space is pretty straightforward. Could you devise a constant space solution?
     * Note: The 2 values must be returned in ascending order
     * 
    */

    TreeNode prev = null;

    public void inorder(TreeNode root, int[] ans){
        if(root == null) {
            return;
        }

        inorder(root.left,ans);

        if (prev != null) {
            if (prev.val > root.val) {
                if (ans[0] == -1) {
                    ans[1] = prev.val;
                    ans[0] = root.val;
                }
                else {
                    ans[0] = root.val;
                }
            }
        }

        prev = root;
        inorder(root.right,ans);
    }

    public int[] recoverTree(TreeNode A) {
        int[] ans = {-1,-1};
        inorder(A,ans);
        
        return ans;
    }

    public static void main(String[] args) {
        
    }
}