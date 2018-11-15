import java.util.EmptyStackException;

public class LinkedStack<T> implements StackInterface<T>{
    private Node head;
    private int size;

    private class Node{
        private T item;
        private Node next;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public void push(T anEntry){
        if (isEmpty()){
          throw new EmptyStackException();
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
    }

    public T peek(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return head.item;
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T temp = head.item;
        head = head.next;
        size--;
        return temp;
    }

    public void clear(){
        head = null;
    }
}