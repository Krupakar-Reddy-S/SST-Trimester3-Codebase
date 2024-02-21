import java.util.Stack;

public class InorderIterative {

    /* 
     * Perform Inorder Traversal of a Binary Tree using Iterative Approach
     *          
    */

    // TC = O(N), SC = O(N)
    public static void inorderIterative1(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.println(current.val);
            current = current.right;
        }
    }

    // TC = O(N), SC = O(1)
    public static void inorderIterative2(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode current = root;
        current = inorderPredecessor(current);

        while (current != null) {
            System.out.println(current.val);
            current = inorderPredecessor(current);
        }
    }

    public static TreeNode inorderPredecessor(TreeNode node) {
        while (node != null) {
            if (node.left == null) {
                System.out.println(node.val);
                node = node.right;
            }
            else {
                TreeNode predecessor = node.left;
                while (predecessor.right != null && predecessor.right != node) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = node;
                    node = node.left;
                } 
                else {
                    predecessor.right = null;
                    System.out.println(node.val);
                    node = node.right;
                }
            }
        }

        return null;
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
        System.out.println("Inorder Traversal:");
        inorderIterative2(rootA);
    }
}
