package datastructures.trees;

import datastructures.BinaryHeap;

import java.util.Arrays;


public abstract class BinaryHeapAbstract implements BinaryHeap {
    private static final int CAPACITY = 10;
    private int lastIndex = -1;
    private Node[] data;

    BinaryHeapAbstract(int x) {
        lastIndex += 1;
        data = new Node[CAPACITY];
        data[lastIndex] = new Node(x);
    }

    @Override
    public boolean isEmpty() {
        return lastIndex == -1;
    }

    Node getNode(int index) {
        return data[index];
    }

    @Override
    public void insert(int x) {
        lastIndex += 1;
        if (lastIndex == CAPACITY) {
            resizeArray();
        }

        Node newNode = new Node(x);
        data[lastIndex] = newNode;

        int parentIndex = (lastIndex - 1) / 2;

        if (!isBetter(parentIndex)) {
            heapifyUp(lastIndex);
        }
    }

    private void heapifyUp(int lastIndex) {
        int currentIdx = lastIndex;
        int parentIdx = (currentIdx - 1) / 2;

        while (!isBetter(parentIdx)) {
            swap(parentIdx, currentIdx);
            parentIdx = currentIdx;
        }
    }

    private void swap(int upperIndex, int lowerIndex) {
        Node temp = data[lowerIndex];
        data[lowerIndex] = data[upperIndex];
        data[upperIndex] = temp;
    }

    @Override
    public int extract() {
        if(lastIndex < 0){
            return -1;
        }
        int currentIndex = 0;
        int extractedValue = data[currentIndex].value;

        swap(currentIndex, lastIndex);

        while (!isBetter(currentIndex)) {
           heapifyDown(currentIndex);
        }

        lastIndex -= 1;
        return extractedValue;
    }

    private void heapifyDown(int parentIndex) {
        while(!isBetter(parentIndex)) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = 2 * parentIndex + 2;

            int child = isBetter(leftChildIndex, rightChildIndex)
                    ? leftChildIndex : rightChildIndex;
            swap(parentIndex, child);
            parentIndex = child;
        }
    }

    @Override
    public int peek() {
        return data[0].value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lastIndex + 1; i++) {
            result.append(data[i].value);
            result.append(" ");
        }
        return result.toString();
    }

    private void resizeArray() {
        data = Arrays.copyOf(data, CAPACITY * 2);
    }

    public int size(){
        return lastIndex + 1;
    }

    abstract boolean isBetter(int lastIndex);

    abstract boolean isBetter(int leftIndex, int rightIndex);

}
