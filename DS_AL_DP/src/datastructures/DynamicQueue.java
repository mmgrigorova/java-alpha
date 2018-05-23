package datastructures;

public class DynamicQueue {
    private Node head;
    private Node tail;

    public DynamicQueue() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void enqueue(int x) {
        Node newElement = new Node(x);
        if (isEmpty()) {
            tail = head = newElement;
        } else {
            tail.next = newElement;
            tail = newElement;
        }
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        int result = head.value;
        head = head.next;

        if (head == null) {
            tail = null;
        }

        return result;
    }

    public int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue is empty.");
        }
        return head.value;
    }
}

