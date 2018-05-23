import datastructures.Node;

import java.util.EmptyStackException;

public class DynamicStack {
    Node top;

    public DynamicStack(){
        top = null;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void push(int x){
        Node newElement = new Node(x);
        newElement.next = top;
        top = newElement;
    }

    public int pop(){
        int result;
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            result = top.value;
            top = top.next;
        }

        return result;
    }

    public int peek(){
        int result;
        if(isEmpty()){
            throw new EmptyStackException();
        } else {
            result = top.value;
        }

        return result;
    }
}
