package datastructures.trees;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    // when current node is null we have reached the place of insertion
    private Node insertRecursive(Node current, int x) {
        if (current == null) {
            return new Node(x);
        }

        if (current.value < x) {
            current.right = insertRecursive(current.right, x);
        } else if (current.value > x) {
            current.left = insertRecursive(current.left, x);
        } else {
            return current; //because value already exists
        }

        return current;
    }

    public void insert(int x) {
        root = insertRecursive(root, x);
    }

    private Node searchRecursive(int x, Node node) {
        if (node.value == x) {
            return node;
        }

        if (x < node.value) {
            return searchRecursive(x, node.left);
        } else if (x > node.value) {
            return searchRecursive(x, node.right);
        }

        return null;
    }

    public Node search(int x) {
        return searchRecursive(x, root);
    }

    private Node deleteRecursive(int x, Node current) {
        if (current.value == x) {
            if (current.left == null && current.right == null) {
                return null;
            } else if (current.left == null) {
                current = current.right;
                current.right = null;

            } else if (current.right == null) {
                current = current.left;
                current.left = null;
            } else {
                Node smallestNode = smallestNode(current.right);
                current.value = smallestNode.value;
                current.right = deleteRecursive(smallestNode.value, current.right);
            }
            return current;
        }
        if (x < current.value) {
            current.left = deleteRecursive(x, current.left);
        } else {
            current.right = deleteRecursive(x, current.right);

        }
        return current;
    }

    public void delete(int x) {
        deleteRecursive(x, root);
    }

    private Node smallestNode(Node rightTree) {
        if (rightTree.left == null) {
            return rightTree;
        } else {
            return smallestNode(rightTree.left);
        }
    }

    private boolean isBstTreeRecursive(Node node, int minValue, int maxValue){
        if (node == null){
            return true;
        }

        return node.value >= minValue && node.value < maxValue
                && isBstTreeRecursive(node.left, minValue, node.value)
                && isBstTreeRecursive(node.right, node.value, maxValue);
    }

    public boolean isBinarySearchTree(){
        return isBstTreeRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


}
