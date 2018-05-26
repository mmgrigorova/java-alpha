package datastructures.trees;

import datastructures.TraversableBfs;
import datastructures.TraversableDsf;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree implements TraversableBfs, TraversableDsf {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }


    public Node search(int x) {
        return searchRecursive(x, root);
    }

    public void insert(int x) {
        root = insertRecursive(root, x);
    }

    public void delete(int x) {
        deleteRecursive(x, root);
    }

    public boolean isBinarySearchTree() {
        return isBstTreeRecursive(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    @Override
    public void bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current == null) {
                throw new AssertionError();
            }
            System.out.printf("%d ", current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    @Override
    public void dfsInOrder() {
        dfsInOrderUtil(root);
    }


    @Override
    public void dfsPreOrder() {
        if (root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();

        stack.push(root);

        while(!stack.empty()){
            Node current = stack.pop();
            System.out.printf("%d ", current.value);

            if (current.right != null){
                stack.push(current.right);
            }

            if (current.left != null){
                stack.push(current.left);
            }

        }

    }

    @Override
    public void dfsPostOrder() {
        dfsPostOrderUtil(root);
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


    private Node smallestNode(Node rightTree) {
        if (rightTree.left == null) {
            return rightTree;
        } else {
            return smallestNode(rightTree.left);
        }
    }

    private boolean isBstTreeRecursive(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        return node.value >= minValue && node.value < maxValue
                && isBstTreeRecursive(node.left, minValue, node.value)
                && isBstTreeRecursive(node.right, node.value, maxValue);
    }

    private void dfsInOrderUtil(Node current) {
        if(current == null){
            return;
        }

        dfsInOrderUtil(current.left);
        System.out.printf("%d ", current.value);
        dfsInOrderUtil(current.right);
    }

    private void dfsPostOrderUtil(Node current) {
        if(current == null){
            return;
        }

        dfsInOrderUtil(current.left);
        dfsInOrderUtil(current.right);
        System.out.printf("%d ", current.value);
    }

}
