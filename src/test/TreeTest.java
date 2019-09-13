package test;

import main.trees.BinaryTree;
import main.trees.nodes.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TreeTest {

    @Test
    public void evaluateTreeSystem() {
        BinaryTree<Integer> numbers = BinaryTree.createSample();

        //Test Phase
        assertEquals(3, numbers.depth());
    }

    @Test
    public void evaluateSimpleSearch() {
        BinaryTree<Integer> numbers = BinaryTree.createSample();

        //Test Phase
        assertTrue(numbers.search(5));
    }
}
