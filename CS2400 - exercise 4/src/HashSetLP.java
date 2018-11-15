public class HashSetLP<T> implements HashSetInterface<T>{
    private T[] elements;
    private int numberOfEntries;
    private int size = 157;

    public HashSetLP(){
        elements = (T[]) new Object[size];
        numberOfEntries = 0;
    }

    //returns the size of the set
    public int size(){
        return size;
    }


    //returns whether or not the set is empty
    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    //determine whether the set contains an item
    public boolean contains(T item){
        int probeAttempts = 0;
        int hashValue = hash(item);

        //returns true if the set contains the item
        while (elements[hashValue] != null){
            if (elements[hashValue].equals(item)){
                return true;
            }

            hashValue = (hashValue + 1) % elements.length;
            probeAttempts++;

            if (probeAttempts > 31){
                return false;
            }

        }

        //The set doesn't contain the item
        return false;
    }

    //turns the items of the set into an array
    //
    public T[] toArray(){
        T[] elementsToArray = (T[]) new Object[numberOfEntries];
        int nextIndex = 0;
        for (int i = 0; i < elements.length; i++){
            if (elements[i] != null){
                elementsToArray[nextIndex++] = elements[i];
            }
        }

        return elementsToArray;
    }

    //inserts item in the set
    //array of length 7 [a. b. c. d. e. f. .g]

    public boolean add(T item){
        //NO DUPLICATES
        int hashValue = hash(item);
        int probeAttempts = 0;

        //if the set is full or contains the item
        if (numberOfEntries == size() || contains(item)){
            return false;
        }

        //Finds an occupied spot
        //Use linear probing to find a free space,
        while(elements[hashValue] != null && !elements[hashValue].equals(item)){
            hashValue = (hashValue + 1) % elements.length; //Go on to next index
            probeAttempts++;
        }

        //if it already contains the item or the set is full
        //when we are adding 156, the noe is 157
        //when we are trying to add 157 there are 157 entries total
        //when we are adding 0 there are 0 entries total
        if (probeAttempts > 31){
            return false;
        }

        if (elements[hashValue] != item) {
            elements[hashValue] = item;
            numberOfEntries++;
            return true;
        }
        return false;
    }
    //removes an item from the set if its found
    public T remove(T item){
        int hashValue = hash(item);

        if(item == null || elements[hashValue] == null || !contains(item)){
            return null;
        }

        if (contains(item)) {
            T temp = elements[hashValue];
            elements[hashValue] = null;
            size--;
            numberOfEntries--;
            return temp;
        }

        return null;
    }

    //removes all the elements of the set
    public void clear(){
        for (int i = elements.length - 1; i >= 0; i--){
            elements[i] = null;
        }
        numberOfEntries = 0;
    }

    //private hash function for mapping the values to certain indexes
    private int hash(T item){
        int hash = (Math.abs(item.hashCode()) % elements.length);
        return hash;
    }

}