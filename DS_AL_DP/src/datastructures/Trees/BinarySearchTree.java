package datastructures.Trees;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    // when current node is null we have reached the place of insertion
    private Node insertRecursive(Node current, int x){
        if (current == null){
            return new Node(x);
        }

        if(current.value < x){
           current.right = insertRecursive(current.right, x);
        } else if (current.value > x){
           current.left = insertRecursive(current.left, x);
        } else {
            return current; //because value already exists
        }

        return current;
    }

    public void insert(int x){
        root = insertRecursive(root, x);
    }

    private Node searchRecursive(int x, Node node){
        if(node.value == x){
            return node;
        }

        if(x < node.value){
            return searchRecursive(x, node.left);
        } else if (x > node.value){
            return searchRecursive(x, node.right);
        }

        return null;
    }

    public Node search(int x){
       return searchRecursive(x, root);
    }

    private void deleteRecursive(int x, Node parent){
        if(parent.value == x){
            if(parent.left == null && parent.right == null){
                parent = null;
                return;
            } else if (parent.left == null){
              parent = parent.right;
              deleteRecursive(x, parent);
            } else if (parent.right == null){
                parent = parent.left;
                deleteRecursive(x, parent);
            } else {
                parent = smallestNode(Node node);
                parent.left = null;
            }
        }
        if (x < parent.value){
            deleteRecursive(x, parent.left);
        } else {
            deleteRecursive(x, parent.right);

        }
    }

    public void delete(int x){
         deleteRecursive(x,root);
    }

    private Node smallestNode(Node node){
        if (node.left.value < 0){}
    }

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        b.insert(6);
        b.insert(7);
        b.insert(4);
        b.insert(5);
        b.insert(6);

        System.out.println(b.search(4).value);

    }
}
