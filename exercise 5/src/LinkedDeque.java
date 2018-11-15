public class LinkedDeque<T> implements DequeInterface<T> {
    //Doubly linked chain with head and tail references
    private int numberOfEntries;
    private Node head; //Node at front of deque
    private Node tail; //Node at end of deque


    public LinkedDeque() {
        head = null;
        tail = null;
        numberOfEntries = 0;
    }

    public void addToFront(T newEntry){ //Good
        Node tempNode = new Node(newEntry);
        if (isEmpty()){
            head = tempNode;
            tail = tempNode;
        }else {
            tempNode.next = head; //Points tempNode to head
            head.previous = tempNode; //Points the former head to tempNode
            head = tempNode; //make tempNode the new head
        }
        numberOfEntries = numberOfEntries + 1; //increase the number of entries
    }

    public void addToBack(T newEntry){ //Good
        Node tempNode = new Node(newEntry);
        if (isEmpty()){
            head = tempNode;
            tail = tempNode;
        }else {
            tail.next = tempNode; //Points tail to tempNode
            tempNode.previous = tail; //Points tempNode to tail
            tail = tempNode; //Make tempNode the new tail
        }

        numberOfEntries = numberOfEntries + 1;
    }

    public T removeFront(){
        T headData = head.data;
        if (isEmpty()){
            throw new EmptyQueueException();
        }

        if (numberOfEntries == 1){
            head = null;
            tail = null;
        }else{
            head = head.next;
            head.previous = null;
        }

        numberOfEntries = numberOfEntries - 1;
        return headData;
    }

    public T removeBack(){
        if (isEmpty()){
            throw new EmptyQueueException();
        }
        T tailData = tail.data;
        if (numberOfEntries == 1){
            head = null;
            tail = null;
        }else{
            tail = tail.previous;
            tail.next = null;
        }

        numberOfEntries = numberOfEntries - 1;
        return tailData;
    }

    public T getFront(){
        T headData = null;
        if (isEmpty()){
            throw new EmptyQueueException();

        }else if (!isEmpty()) {
            headData = head.data;
        }
        return headData;
    }

    public T getBack(){
        T tailData = null;
        if (isEmpty()){
            throw new EmptyQueueException();

        }else if (!isEmpty()){
            tailData = tail.data;
        }
        return tailData;
    }

    public boolean isEmpty(){
        return ((head == null && tail == null) || numberOfEntries == 0);
    }

    public void clear(){
        head = null;
        tail = null;
    }

    //Define Node Class
    private class Node{
        private Node next;
        private Node previous;
        private T data;

        private Node(T data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
}