import java.util.Stack;

public class PostorderIterative {

    /* 
     * Perform Postorder Traversal of a Binary Tree using Iterative Approach
     * 
    */

    // TC = O(N), SC = O(N)
    public static void postorderIterative(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastVisited = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode current = stack.peek();

            if (current.right == null || current.right == lastVisited) {
                stack.pop();
                System.out.println(current.val);
                lastVisited = current;
            } 
            else {
                root = current.right;
            }
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
        System.out.println("Postorder Traversal:");
        postorderIterative(rootA);

        // rootA.postOrder();
    }
}
