package datastructures.trees;

public class BstTest {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        b.insert(6);
        b.insert(7);
        b.insert(4);
        b.insert(5);
        b.insert(8);
        b.insert(10);
        b.insert(3);
        b.insert(30);

        System.out.println(b.search(4).value);

        b.delete(4);

        System.out.println(b.isBinarySearchTree());
    }
}
