package main.trees.nodes;

import java.lang.reflect.Array;

public class Node<T> {
    private int depthFromRoot;
    private T content;
    private Node[] children;
    private int maxChildren = -1;
    private static boolean searchResult;
    private static Node nodeSearchResult;

    public Node(T content, Node... children){
        this.content = content;
        this.children = children;
    }

    public Node(T content){
        this.content = content;
        children = new Node[0];
    }

    public Node() {
        content = null;
        children = new Node[0];
    }

    private int[] depths = new int[0];
    private int stackoverflow = 0; //Prevention System of StackOverflow Error
    private void depth(Node<? extends Object> node, int previousDepth) {
        stackoverflow++;
        if(stackoverflow <= 1000) {
            if(node.hasChildren()) {
                for(Node child:node.getChildren()) {
                    depth(child, previousDepth+1);
                }
            } else {
                int[] temp = new int[depths.length + 1];
                for(int i = 0; i < depths.length; i++) {
                    temp[i] = depths[i];
                }
                temp[depths.length] = previousDepth;
                depths = temp;
            }
        } else {
            System.out.println("Operation canceled due to Stack Overflow Error");
        }
    }

    public int depth() {
        stackoverflow = 0;
        depths = new int[0];
        if(this.hasChildren()) {
            depth(this, 0);
            int max = depths[0];
            for(int i:depths) {
                if(i > max) {
                    max = i;
                }
            }
            return max;
        } else {
            return 0;
        }
    }

    public boolean search(T qcontent) {
        searchResult = false;
        searchRecursive(this, qcontent);
        return searchResult;
    }

    private void searchRecursive(Node node, T qcontent) {
        if(node.getContent() == qcontent) {
            searchResult = true;
        } else {
            if(node.hasChildren()) {
                for(Node child:node.getChildren()) {
                    child.searchRecursive(child, qcontent);
                }
            } else {
                //No Children => End of Recursion
            }
        }
    }

    public Node searchNode(T qcontent) {
        nodeSearchResult = null;
        searchNodeRecursive(qcontent);
        return nodeSearchResult;
    }

    private void searchNodeRecursive(T qcontent) {
        if(this.content == qcontent) {
            nodeSearchResult = this;
        } else {
            if(this.hasChildren()) {
                for(Node child:this.getChildren()) {
                    child.searchNodeRecursive(qcontent);
                }
            }
        }
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public Node[] getChildren() {
        return children;
    }

    private void setChildren(Node[] children) {
        Node[] temporaryChildren = this.children;
        this.children = children;
        if(isFull()) {
            this.children = temporaryChildren;
            System.out.println("The given array is larger than the maximum allowed children!");
        }
    }

    private void addChild(Node<? extends Object> child) {
        if(!isFull()) {
            child.setMaxChildren(this.maxChildren);
            child.setDepthFromRoot(this.getDepthFromRoot() + 1);
            Node[] copy = new Node[children.length + 1];
            System.arraycopy(children, 0, copy, 0, children.length);
            copy[children.length] = child;
            children = copy;
        } else {
            System.out.println("[System/Warning]: Child couldn't be added due to lack of free places in this branch.");
        }
    }

    public void addChildren(Node... nodychildren) {
        for(Node<? extends Object> n:nodychildren) {
            addChild(n);
        }
    }

    public boolean hasChildren() {
        if(children != null) {
            if(children.length != 0) {
                if(children[0] != null) {
                    return  true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean isFull() {
        return (maxChildren != -1) && getChildren().length >= maxChildren;
    }

    public int setMaxChildren(int max) {
        this.maxChildren = max;
        if(this.isFull()) {
            System.out.println("There are already more children than the max size. To prevent data loss we decided " +
                    "to reset the maximum amount children to unlimited");
            resetMaxChildren();
            return 0;
        } else {
            return 1;
        }
    }

    public void resetMaxChildren() {
        this.maxChildren = -1;
    }

    public int getDepthFromRoot() {
        return depthFromRoot;
    }

    public void setDepthFromRoot(int depthFromRoot) {
        this.depthFromRoot = depthFromRoot;
    }

    static Node[] selection = new Node[0];
    public void selectAllLower(Node node) {
        Node[] temp = new Node[selection.length + 1];
        for(int i = 0; i < selection.length; i++) {
            temp[i] = selection[i];
        }
        temp[selection.length] = node;
        selection = temp;

        if(node.hasChildren()) {
            for(Node nodechildren:node.getChildren()) {
                selectAllLower(nodechildren);
            }
        }
    }

    public Node[] toNodeArray() {
        selection = new Node[0];
        selectAllLower(this);
        return selection;
    }

    //Not tested
    public T[] toArray() {
        selection = new Node[0];
        selectAllLower(this);
        if(selection.length == 0) {
            return (T[]) Array.newInstance(((T)(new Object())).getClass(), 0);
        } else {
            T[] contentArray = (T[]) Array.newInstance(selection[0].getClass(), selection.length);
            for(int i = 0; i < selection.length; i++) {
                contentArray[i] = (T) selection[i].getContent();
            }
            return contentArray;
        }
    }
}
