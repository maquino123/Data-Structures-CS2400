import java.util.EmptyStackException;
public class ArrayStack<T> implements StackInterface<T>{
    private T[] stack;
    private int nextElement;
    private static final int maxCapacity = 25;

    /**
      * Constructor that creates a stack of the size of initialSize
      * @param initialSize
     */
    public ArrayStack(int initialSize){
        if (initialSize <= 0){
            stack = (T[]) new Object[maxCapacity];
        }else{
            stack = (T[]) new Object[initialSize];
        }

        nextElement = 0;
    }

    /**
     * Default constructor that creates a stack with the maxCapacity;
     */
    public ArrayStack(){
        this(maxCapacity);
    }

    /**
     * Tests if the stack is empty
     * @return True if empty false otherwise
     */
    public boolean isEmpty(){
        return nextElement == 0;
    }

    /**
     * Inserts an element into the top of the stack
     * @param anEntry
     */
    public void push(T anEntry){
        if (nextElement == stack.length){
            nextElement++;
        }
        stack[nextElement] = anEntry;
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element in the stack
     */
    public T peek(){
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[nextElement-1];
    }

    /**
     * Removes and returns the element at the top of the stack
     * T returns the element at the top of the stack
     */
    public T pop(){
        T topElement = peek();
        stack[nextElement] = null;
        nextElement--;
        return topElement;
    }

    /**
     * Removes all items from the stack.
     */
    public void clear(){
        while (! isEmpty()){
            pop();
        }
    }


}