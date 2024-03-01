import java.util.Stack;

public class PreorderIterative {

    /* 
     * Perform Preorder Traversal of a Binary Tree using Iterative Approach
     * 
    */

    // TC = O(N), SC = O(N)
    public static void preorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                System.out.println(current.val);
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode rootA = new TreeNode(10);
        rootA.left = new TreeNode(9);
        rootA.right = new TreeNode(8);
        rootA.left.left = new TreeNode(7);
        rootA.left.right = new TreeNode(6);
        rootA.right.left = new TreeNode(5);
        rootA.right.right = new TreeNode(4);

        System.out.println(rootA);
        System.out.println("Preorder Traversal:");
        preorderIterative(rootA);

        // rootA.preOrder();
    }
}
