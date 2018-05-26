package datastructures;

public interface BinaryHeap {
    boolean isEmpty();

    void insert(int x);

    int extract();

    int peek();
}
