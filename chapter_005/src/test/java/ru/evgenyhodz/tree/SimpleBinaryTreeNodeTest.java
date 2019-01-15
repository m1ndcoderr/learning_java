package ru.evgenyhodz.tree;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 05.03.2017
 */
public class SimpleBinaryTreeNodeTest {
    /**
     * Reference to balanced tree.
     */
    private SimpleBinaryTreeNode balanced;
    /**
     * Reference to disbalanced tree.
     */
    private SimpleBinaryTreeNode disbalanced;

    /**
     * Creating a balanced tree.
     */
    @Before
    public void createBalancedTree() {
        balanced = new SimpleBinaryTreeNode(5);
        balanced.left = new SimpleBinaryTreeNode(10);
        balanced.right = new SimpleBinaryTreeNode(15);
        balanced.left.left = new SimpleBinaryTreeNode(20);
        balanced.left.right = new SimpleBinaryTreeNode(25);
        balanced.right.left = new SimpleBinaryTreeNode(30);
        balanced.right.right = new SimpleBinaryTreeNode(35);
    }

    /**
     * Creating a disbalanced tree.
     */
    @Before
    public void createDisBalancedTree() {
        disbalanced = new SimpleBinaryTreeNode(5);
        disbalanced.left = new SimpleBinaryTreeNode(10);
        disbalanced.right = new SimpleBinaryTreeNode(15);
        disbalanced.left.left = new SimpleBinaryTreeNode(20);
        disbalanced.left.right = new SimpleBinaryTreeNode(25);
        disbalanced.right.left = new SimpleBinaryTreeNode(30);
        disbalanced.right.right = new SimpleBinaryTreeNode(35);
        disbalanced.right.right.right = new SimpleBinaryTreeNode(40);
        disbalanced.right.right.right.right = new SimpleBinaryTreeNode(45);
    }

    /**
     * Validation.
     */
    @Test
    public void whenCheckBalancedTreeThenGetTrue() {
        assertThat(new SimpleBinaryTreeNode().isBalanced(balanced), is(true));
    }

    /**
     * Validation.
     */
    @Test
    public void whenCheckDisbalancedTreeThenResultIsFalse() {
        assertThat(new SimpleBinaryTreeNode().isBalanced(disbalanced), is(false));
    }
}