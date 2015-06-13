/**
 * Interface describing the List abstract data type.
 */
public interface List<T> {

    /**
     * Adds a value to to the end of the list.
     * @param value the value to add.
     */
    public void append(T value);

    /**
     * Adds a value to to the front of the list.
     * @param value the value to add.
     */
    public void prepend(T value);

    /**
     * Determine whether or not this list is empty.
     * @return true if the list is empty, false if it contains items.
     */
    public boolean isEmpty();

    /**
     * @return the number of items in this list, or zero if it is empty.
     */
    public int length();

    /**
     * Returns the element at the given index.
     * @param  index the index to access.
     * @return the element at `index`
     * @throws IndexOutOfBoundsException if the index is less than zero or
     *         greater than the current length of the list.
     */
    public T get(int index) throws IndexOutOfBoundsException;
}
