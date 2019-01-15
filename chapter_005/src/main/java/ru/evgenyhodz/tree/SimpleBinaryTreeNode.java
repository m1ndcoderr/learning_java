package ru.evgenyhodz.tree;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 03.03.2017
 */
public class SimpleBinaryTreeNode {

    private int data;

    protected SimpleBinaryTreeNode left;

    protected SimpleBinaryTreeNode right;

    public SimpleBinaryTreeNode(){
        this.left = null;
        this.right = null;
    }

    public SimpleBinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public boolean isBalanced(SimpleBinaryTreeNode root) {
        int result = checkBalance(root);
        return result > 0;
    }

    private int checkBalance(SimpleBinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftH = checkBalance(root.left);
        if (leftH == -1) {
            return -1;
        }
        int rightH = checkBalance(root.right);
        if (rightH == -1) {
            return -1;
        }
        int diff = leftH - rightH;
        if (Math.abs(diff) > 1) {
            return -1;
        }
        return 1 + Math.max(leftH, rightH);
    }
}
