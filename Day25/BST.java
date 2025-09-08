package Day25;

// This will be my TreeNode class
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BST {
    private static boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        if (helper(root.left, min, root.val) && helper(root.right, root.val, max)) {
            return true;
        }

        return false;
    }

    public static boolean isBST(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(4);
        tree.right.left = new TreeNode(3);
        tree.right.right = new TreeNode(6);

        // This is one example from problem statement
        // Input: root = [5, 1, 4, null, null, 3, 6]
        // Output: false

        boolean check = isBST(tree);
        System.out.println("This tree is BST : " + check);
    }

}
