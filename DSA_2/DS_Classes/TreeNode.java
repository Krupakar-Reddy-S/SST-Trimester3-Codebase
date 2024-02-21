import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public void preOrder() {
        preOrder(this);
    }

    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(this, "", true, sb);
        return sb.toString();
    }

    private void printTree(TreeNode node, String prefix, boolean isTail, StringBuilder sb) {
        // if (node.right != null) {
        //     printTree(node.right, prefix + (isTail && !prefix.isEmpty() ? "│   " : "    "), false, sb);
        // }
        // sb.append(prefix + (isTail ? "└── " : "┌── ") + node.val + "\n");
        // if (node.left != null) {
        //     printTree(node.left, prefix + (!isTail && !prefix.isEmpty() ? "│   " : "    "), true, sb);
        // }

        if (node.right != null) {
            printTree(node.right, prefix + (isTail && !prefix.isEmpty() ? "|   " : "    "), false, sb);
        }
        sb.append(prefix + (isTail ? "+-- " : "+-- ") + node.val + "\n");
        if (node.left != null) {
            printTree(node.left, prefix + (!isTail && !prefix.isEmpty() ? "|   " : "    "), true, sb);
        }
    }

    public static ArrayList<Integer> Serialize(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                result.add(null);
            } else {
                result.add(curr.val);
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return result;

    }

    public static TreeNode Deserialize(ArrayList<Integer> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr.get(0));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        for (int i = 1; i < arr.size(); i++) {
            TreeNode curr = queue.poll();
            if (arr.get(i) != null) {
                curr.left = new TreeNode(arr.get(i));
                queue.add(curr.left);
            }
            if (++i < arr.size() && arr.get(i) != null) {
                curr.right = new TreeNode(arr.get(i));
                queue.add(curr.right);
            }
        }

        return root;
    }

    public static TreeNode Deserialize(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        for (int i = 1; i < arr.length; i++) {
            TreeNode curr = queue.poll();
            if (arr[i] != Integer.MIN_VALUE) {
                curr.left = new TreeNode(arr[i]);
                queue.add(curr.left);
            }
            if (++i < arr.length && arr[i] != Integer.MIN_VALUE) {
                curr.right = new TreeNode(arr[i]);
                queue.add(curr.right);
            }
        }

        return root;
    }

    public static TreeNode subTreeNode(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        TreeNode left = subTreeNode(root.left, val);
        TreeNode right = subTreeNode(root.right, val);

        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }

        return null;
    }
}