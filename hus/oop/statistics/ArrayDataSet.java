package hus.oop.statistics;

import java.util.Arrays;

public class ArrayDataSet extends AbstractDataSet {
    private static final int DEFAULT_CAPACITY = 16;
    private double[] data;
    private int size;

    /**
     * Constructor to initialize the dataset.
     */
    public ArrayDataSet() {
        this.data = new double[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Returns the size of the dataset.
     * @return the size of the dataset.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns the value of the element at the specified index.
     * @param index the index of the element.
     * @return the value of the element at the specified index.
     */
    @Override
    public double get(int index) {
        if (checkBoundaries(index, size - 1)) {
            return data[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Sets the data at the specified index to the given value.
     * @param value the new value.
     * @param index the index to set.
     */
    @Override
    public void set(double value, int index) {
        if (checkBoundaries(index, size - 1)) {
            data[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Appends data to the end of the dataset.
     * If the array is full, it allocates more space.
     * @param value the value to append.
     */
    @Override
    public void append(double value) {
        if (size == data.length) {
            allocateMore();
        }
        data[size++] = value;
    }

    /**
     * Inserts data at the specified index in the dataset.
     * If the array is full, it allocates more space.
     * @param value the value to insert.
     * @param index the index to insert at.
     */
    @Override
    public void insert(double value, int index) {
        if (checkBoundaries(index, size)) {
            if (size == data.length) {
                allocateMore();
            }
            // Shift elements to make space for the new value
            System.arraycopy(data, index, data, index + 1, size - index);
            data[index] = value;
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Removes the element at the specified index from the dataset.
     * @param index the index to remove.
     */
    @Override
    public void remove(int index) {
        if (checkBoundaries(index, size - 1)) {
            // Shift elements to remove the element at the specified index
            System.arraycopy(data, index + 1, data, index, size - index - 1);
            size--;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    /**
     * Allocates double the current capacity of the array.
     */
    private void allocateMore() {
        int newCapacity = data.length * 2;
        data = Arrays.copyOf(data, newCapacity);
    }

    /**
     * Converts the dataset to an array of type double.
     * @return an array representation of the dataset.
     */
    @Override
    public double[] toArray() {
        return Arrays.copyOf(data, size);
    }
}
