public class ArrayBag<T> implements BagInterface<T> {
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25.
     */
    public ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given capacity.
     *
     * @param desiredCapacity The integer capacity desired.
     */

    public ArrayBag(int desiredCapacity) {
        if (desiredCapacity > MAX_CAPACITY) {
            throw new IllegalStateException("Attempt to create a bag " +
                    "whose capacity exceeds " +
                    "allowed maximum.");
        }


        // The cast is safe because the new array contains null entries
        //noinspection unchecked
        bag = (T[]) new Object[desiredCapacity]; // Unchecked cast
        numberOfEntries = 0;
    }

    /**
     * Gets the current number of entries in this bag.
     *
     * @return The integer number of entries currently in the bag.
     */
    public int getCurrentSize() {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     *
     * @return True if the bag is empty, or false if not.
     */
    public boolean isEmpty() {
        return numberOfEntries == 0;
        }

    /**
     * Adds a new entry to this bag.
     *
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    public boolean add(T newEntry) {
        try{
            bag[numberOfEntries] = newEntry; //Put newEntry in index 0
            numberOfEntries++; //Increment number of entries
        } catch (Exception e){
            return false;
        }

        return true;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     *
     * @return Either the removed entry, if the removal.
     * was successful, or null.
     */
    public T remove() {
        return removeAt(numberOfEntries - 1);
    }

    /**
     * Removes one occurrence of a given entry from this bag.
     *
     * @param anEntry The entry to be removed.
     * @return True if the removal was successful, or false if not.
     */
    public boolean remove(T anEntry) {
        for (int i = 0; i < numberOfEntries; ++i){
            if (anEntry.equals(bag[i])){
                if (numberOfEntries > 0){
                    bag[i] = bag[numberOfEntries + 1];
                    bag[numberOfEntries + 1] = null;
                }

                return true;
            }
        }

        return false;
    }

    /**Helper method for remove methods */

    private T removeAt(int index){
        T tempElement = null;
        try{
            tempElement = bag[index];
            --numberOfEntries;
            bag[index] = null;
        }

        catch (Exception e){
            return null;
        }

        return tempElement;
    }

    /**
     * Removes all entries from this bag.
     */
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     *
     * @param anEntry The entry to be counted.
     * @return The number of times anEntry appears in the bag.
     */
    public int getFrequencyOf(T anEntry) {
        int frequencyOfElement = 0;
        for (int i = 0; i < numberOfEntries; i++){
            if (anEntry.equals((bag[i]))){
                    frequencyOfElement++;
                }
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

        boolean containsGivenEntry = false;

        for (int i = 0; i < numberOfEntries; i++){
            if (anEntry.equals(bag[i])){
                containsGivenEntry = true;
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
        // Must be implimented
        T[] convertToArray = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++){
            convertToArray[i] = bag[i];
        }

        return convertToArray;

    }
}
