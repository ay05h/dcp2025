package Day28;

class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int data) {
        val = data;
        left = null;
        right = null;
    }
}

public class BinaryTree {

    private static boolean helper(TreeNode ln, TreeNode rn) {
        if (ln == null && rn == null) {
            return true;
        }
        if (ln == null || rn == null) {
            return false;
        }
        if (ln.val != rn.val) {
            return false;
        }
        return helper(ln.left, rn.right) && helper(ln.right, rn.left);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(1);
        test1.left = new TreeNode(2);
        test1.right = new TreeNode(2);
        test1.left.left = new TreeNode(3);
        test1.left.right = new TreeNode(4);
        test1.right.left = new TreeNode(4);
        test1.right.right = new TreeNode(3);
        System.out.println("[1, 2, 2, 3, 4, 4, 3]: " + isSymmetric(test1));

        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(2);
        test2.left.right = new TreeNode(3);
        test2.right.right = new TreeNode(3);
        System.out.println("[1, 2, 2, null, 3, null, 3]: " + isSymmetric(test2));

        TreeNode test3 = new TreeNode(1);
        System.out.println("[1]: " + isSymmetric(test3));

        TreeNode test4 = null;
        System.out.println("[]: " + isSymmetric(test4));

    }
}
