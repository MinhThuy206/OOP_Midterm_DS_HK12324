package hus.oop.statistics;


public class LinkedListDataSet extends AbstractDataSet {
    private Node head;

    /**
     * Constructor to initialize the linked list.
     */
    public LinkedListDataSet() {
        this.head = null;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    @Override
    public double get(int index) {
        if (checkBoundaries(index, size() - 1)) {
            Node node = getNodeByIndex(index);
            return node.data;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public void set(double value, int index) {
        if (checkBoundaries(index, size() - 1)) {
            Node node = getNodeByIndex(index);
            node.data = value;
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public void append(double value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    @Override
    public void insert(double value, int index) {
        if (checkBoundaries(index, size())) {
            Node newNode = new Node(value);
            if (index == 0) {
                newNode.next = head;
                head = newNode;
            } else {
                Node previous = getNodeByIndex(index - 1);
                newNode.next = previous.next;
                previous.next = newNode;
            }
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    @Override
    public void remove(int index) {
        if (checkBoundaries(index, size() - 1)) {
            if (index == 0) {
                head = head.next;
            } else {
                Node previous = getNodeByIndex(index - 1);
                previous.next = previous.next.next;
            }
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
    }

    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public double[] toArray() {
        double[] array = new double[size()];
        Node current = head;
        for (int i = 0; i < array.length; i++) {
            array[i] = current.data;
            current = current.next;
        }
        return array;
    }

    /**
     * Inner class representing a node in the linked list.
     */
    private static class Node {
        double data;
        Node next;

        Node(double data) {
            this.data = data;
            this.next = null;
        }
    }
}
