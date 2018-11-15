public class LinkedList<T> implements ListInterface<T>{
    private Node head;
    private Node tail;
    private int numberOfEntries;

    public LinkedList(){
        head = null;
        tail = null;
        numberOfEntries = 0;
    }


    public void add(T newEntry){
        Node addedNode = new Node(newEntry);

        if(isEmpty()){
            head = addedNode;
        }else{
            tail.next = addedNode;
        }

        tail = addedNode;
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry){
        Node addedNode = new Node(newEntry);
        //For loop to find position in list
        //Uses two pointers to reference previous node
        Node temp = null;
        Node current = head;
        if (!isEmpty() && newPosition <= getLength() + 1 && newPosition >=1) {
            for (int i = 1; i < newPosition; i++) {
                temp = current;
                current = current.next;
            }
        }

        if (newPosition <= getLength() + 1 && newPosition >= 1){
            if (isEmpty()){
                head = addedNode;
                tail = addedNode;
            }else if (newPosition == getLength() + 1){ //If the Node is added to the end
                tail.next = addedNode;
                tail = addedNode;
            }else if (newPosition == 1) { //If the Node is added to the head
                addedNode.next = head;
                head = addedNode;
            }else { //Anywhere else in the middle of the list
                Node previousNode = temp;
                Node nextNode = previousNode.next;
                addedNode.next = nextNode;
                previousNode.next = addedNode;
            }

            numberOfEntries++;

        }else{
            throw new IndexOutOfBoundsException();
        }

    }


    public T remove(int givenPosition){
        T entry;
        Node temp = null;
        Node current = head;
        if (!isEmpty() && givenPosition <= getLength() && givenPosition >=1) {
            for (int i = 1; i < givenPosition; i++) {
                temp = current;
                current = current.next;
            }
        }
        if (!isEmpty() && givenPosition <= getLength() && givenPosition >= 1){
            if (givenPosition == 1){ //If the given position is the head
                entry = head.data;
                head = head.next;
                if (getLength() == 1){
                    tail = null;
                }
            }else if (givenPosition == getLength()){ //If the given position was the tail
                Node tailPrevious = temp;
                Node removeTail = tailPrevious.next;
                Node tailNext = removeTail.next;
                tailPrevious.next = tailNext;
                entry = removeTail.data;
            }else{ //Anywhere else in the middle of list
                Node previousNode = temp;
                Node removedNode = previousNode.next;
                Node nextNode = removedNode.next;
                previousNode.next = nextNode; //Points the previous node to the node the removed node was referencing
                entry = removedNode.data;
            }

            numberOfEntries--;
        }else{
            throw new IndexOutOfBoundsException();
        }

        return entry;

    }

    public void clear(){
        head = null;
        tail = null;
        numberOfEntries = 0;
    }

    public T replace(int givenPosition, T newEntry){
        T entry;
        Node current = head;
        Node temp = null;
        if (!isEmpty() && givenPosition <= getLength() && givenPosition >=1) {
            for (int i = 1; i < givenPosition; i++) {
                temp = current;
                current = current.next;
            }
        }
        if (givenPosition <= getLength() && givenPosition >= 1 && !isEmpty()){//1 instead of 0 because list is not index based
            Node replaceNode = current;
            replaceNode.data = newEntry;
            entry = replaceNode.data;
        }else{
            throw new IndexOutOfBoundsException();
        }

        return entry;

    }

    public T getEntry(int givenPosition){
        T entry;
        Node current = head;
        Node temp = null;
        if (!isEmpty() && givenPosition <= getLength() && givenPosition >=1) {
            for (int i = 1; i < givenPosition; i++) {
                temp = current;
                current = current.next;
            }
        }
        if (givenPosition <= getLength() && givenPosition >= 1 && !isEmpty()){
            entry = current.data;
        }else{
            throw new IndexOutOfBoundsException();
        }

        return entry;



    }

    public boolean contains(T anEntry){
        Node current = head;
        boolean foundEntry = false;
        while(current != null && !foundEntry){
            if (anEntry.equals(current.data)){
                foundEntry = true;
            }else{
                current = current.next;
            }
        }

        return foundEntry;
    }

    public int getLength(){
        return numberOfEntries;
    }

    public boolean isEmpty(){
        if (getLength() == 0){
            return true;
        }

        return false;
    }

    private class Node{
        private T data;
        private Node next;

        private Node(T data){
            this.data = data;
            this.next = null;
        }
    }
}