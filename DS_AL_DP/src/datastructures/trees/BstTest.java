package datastructures.trees;

public class BstTest {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();

        b.insert(15);
        b.insert(13);
        b.insert(18);
        b.insert(11);
        b.insert(14);
        b.insert(16);
        b.insert(19);
        b.insert(20);

        System.out.println(b.search(14).value);

//        b.delete(14);

        System.out.println(b.isBinarySearchTree());

        System.out.println("BFS: ");
        b.bfs();
        System.out.println("\nPre-order DFS using a stack: ");
        b.dfsPreOrder();
        System.out.println("\nIn-order DFS - recursive: ");
        b.dfsInOrder();
        System.out.println("\nPost-order DFS - recursive: ");
        b.dfsPostOrder();

    }
}
