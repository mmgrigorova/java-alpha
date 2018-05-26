package datastructures.trees;

public class BinaryHeapTest {
    public static void main(String[] args) {
        BinaryHeapMax heap = new BinaryHeapMax(99);
        heap.insert(19);
        heap.insert(36);
        heap.insert(17);
        heap.insert(3);
        heap.insert(25);
        heap.insert(1);
        heap.insert(2);
        heap.insert(7);
        heap.insert(18);

        heap.extract();
        System.out.println(heap);

        heap.extract();


        System.out.println(heap);


    }
}
