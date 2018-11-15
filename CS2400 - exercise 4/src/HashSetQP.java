public class HashSetQP<T> implements HashSetInterface<T> {
    private T[] elements;
    private int numberOfEntries;
    private int size = 157;

    public HashSetQP(){
        elements = (T[]) new Object[size];
        numberOfEntries = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return numberOfEntries == 0;
    }

    public boolean contains(T item){
       int probeAttempts = 0;
       int iterations = 0;
       int hashValue = hash(item);

       while (elements[hashValue] != null){
           if (elements[hashValue].equals(item)){
               return true;
           }

           hashValue = (hashValue + iterations*iterations) % elements.length;
           probeAttempts++;
           iterations++;

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

    public boolean add(T item){
        //NO DUPLICATES
        int probeAttempts = 0;
        int iterations = 0;
        int hashValue = hash(item);

        if (contains(item) || numberOfEntries == size()){
            return false;
        }

        //Finds an occupied spot
        //Use linear probing to find a free space,
        while(elements[hashValue] != null && !elements[hashValue].equals(item) && probeAttempts <= 31){
            hashValue = (hashValue + (iterations*iterations)) % elements.length;
            probeAttempts++;
            iterations++;
        }

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

    public void clear(){
        for (int i = elements.length - 1; i >= 0; i--){
            elements[i] = null;
        }
        numberOfEntries = 0;
    }



    public int hash(T item){
        int hash = Math.abs(item.hashCode()) % elements.length;
        return hash;
    }
}