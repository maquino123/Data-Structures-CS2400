public class LinkedBag<T> implements BagInterface<T> {
    private int numberOEntries;
    private static final int MAX_CAPACITY = 10000;
    private Node head;

    public LinkedBag(){
        head = null;
        numberOEntries = 0;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */

    public int getCurrentSize() {
        return numberOEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        try {
            if (numberOEntries < MAX_CAPACITY){
                head = new Node(newEntry, head);
                ++numberOEntries;
                return true;
            }
        }catch(Exception e) {
            return false;
        }

        return false;


    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal.
     * was successful, or null.
     */
    public T remove() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            temp.next = null;
            --numberOEntries;
            return temp.item;
        }

        return null;
    }

    /** Similar to contains method, but returns the current node instead of a boolean. Helper method for remove method.
     *
     * @param anEntry
     * @return the current node if found, or false if not found.
     */

    private Node getItem(T anEntry) {
        Node currentNode = head;
        boolean containsGivenEntry = false;

        while (!containsGivenEntry && (currentNode != null)){
            if (anEntry.equals(currentNode.item)){
                containsGivenEntry = true;
            }else{
                currentNode = currentNode.next;
            }
        }

        return currentNode;
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        boolean removeSuccess = false;
        Node currentNode = head;
        Node entryNode = getItem(anEntry);
        if (entryNode != null){
            entryNode.item = currentNode.item;
            head = head.next;
            numberOEntries--;
            removeSuccess = true;
        }

        return removeSuccess;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while(!isEmpty())
            remove();
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequencyOfElement = 0;
        Node currentNode = head;
        while((currentNode != null)) {
            if (anEntry.equals(currentNode.item)) {
                frequencyOfElement++;
            }
            currentNode = currentNode.next;
        }
        return frequencyOfElement;
    }

    /**
     * Tests whether this bag contains a given entry.
     *
     * @param anEntry The entry to locate.
     * @return True if the bag contains anEntry, or false if not.
     */
    public boolean contains(T anEntry) {
        Node currentNode = head;
        boolean containsGivenEntry = false;

        while (!containsGivenEntry && (currentNode != null)){
            if (anEntry.equals(currentNode.item)){
                containsGivenEntry = true;
            }else{
                currentNode = currentNode.next;
            }
        }

        return containsGivenEntry;
    }

    /**
     * Retrieves all entries that are in this bag.
     *
     * @return A newly allocated array of all the entries in the bag.
     * Note: If the bag is empty, the returned array is empty.
     */
    public T[] toArray() {
        T[] convertToArray = (T[]) new Object[numberOEntries];
        int nodeIndex  = 0;
        Node currentNode = head;
        while ((currentNode != null)){
            convertToArray[nodeIndex] = currentNode.item;
            nodeIndex++;
            currentNode = currentNode.next;
        }

        return convertToArray;
    }

    // Required to implement linked storage
    private class Node{
        private T item;
        private Node next;

        private Node(T item) {
            this(item, null);
        }

        private Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}