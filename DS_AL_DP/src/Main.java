import datastructures.StaticQueue;

public class Main {
    public static void main(String[] args) throws Exception {
//        DynamicStack s = new DynamicStack();
//
//        s.push(5);
//        s.push(6);
//        s.push(57);
//        s.push(1);
//        s.push(1);
//
//        System.out.println(s.peek());
//
//        while (!s.isEmpty()){
//            System.out.println(s.pop());
//        }
//

        StaticQueue q = new StaticQueue();

        q.enqueue(4);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(2);
        q.enqueue(1);

        while (!q.isEmpty()) {
            System.out.printf("%d ", q.dequeue());
            System.out.println();
        }
    }
}
