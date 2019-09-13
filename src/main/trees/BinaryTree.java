package main.trees;

import main.trees.nodes.Node;

public class BinaryTree<T> extends Tree {

    public BinaryTree(T content, Node... children) {
        setRoot(new Node<T>(content, children));
        if(getRoot().setMaxChildren(2) == 0) {
            System.out.println("[System/SemanticError] Created Tree is not a binary tree");
        }
    }

    public BinaryTree(T content) {
        setRoot(new Node<T>(content));
        getRoot().setMaxChildren(2);
    }

    public BinaryTree() {
        setRoot(new Node<T>());
        getRoot().setMaxChildren(2);
    }

    @Override
    public int depth() {
        return getRoot().depth();
    }

    @Override
    public boolean search(Object query) {
        return getRoot().search((T) query);
    }

    public Node<? extends Object> searchNode(T query) {
        return getRoot().searchNode(query);
    }

    public static BinaryTree<Integer> createSample() {
        BinaryTree<Integer> numbers = new BinaryTree<Integer>(0);
        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        numbers.getRoot().addChildren(one, two);
        Node<Integer> three = new Node<>(3);
        Node<Integer> four = new Node<>(4);
        one.addChildren(three, four);
        Node<Integer> five = new Node<>(5);
        Node<Integer> six = new Node<>(6);
        two.addChildren(five, six);
        Node<Integer> seven = new Node<>(7);
        Node<Integer> eight = new Node<>(8);
        five.addChildren(seven, eight);
        return numbers;
    }
}
