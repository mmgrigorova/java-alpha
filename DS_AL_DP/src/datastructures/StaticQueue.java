package datastructures;

import java.util.EmptyStackException;

public class StaticQueue {
    int head;
    int tail;
    int[] data;

    public StaticQueue(){
        head = -1;
        tail = -1;
        data = new int[10];
    }

    public boolean isEmpty(){
        return tail == -1 || head > tail;
    }

    public void enqueue(int x){
        if(isEmpty()){
            head++;
        }
        tail++;
        if (tail == data.length){
            resizeData();
        }
        data[tail] = x;
    }

    public int dequeue(){
        int result;
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            result = data[head];
            head++;
        }
        return result;
    }


    public int peek(){
        int result;
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            result = data[head];
        }
        return result;
    }

    private void resizeData() {

    }


}
