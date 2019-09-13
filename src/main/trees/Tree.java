package main.trees;

import main.trees.nodes.Node;

public abstract class Tree<T> {
    private Node<T> root;

    public Tree(Node<T> root) {
        setRoot(root);
    }

    Tree() {
        setRoot(new Node<>());
    }

    public Node<T> getRoot() {
        return root;
    }

    void setRoot(Node<T> root) {
        this.root = root;
        this.root.setDepthFromRoot(0);
    }

    public int max(int[] array) {
        assert(array != null);
        int max = array[0];
        for(int i:array) {
            if(i > max) {
                max = i;
            }
        }
        return max;
    }

    public abstract int depth();
    public abstract boolean search(T Object);
}

