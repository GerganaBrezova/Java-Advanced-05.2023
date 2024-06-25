package workshopCustomLinkedList;

import java.util.function.Consumer;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("The index is not valid!");
        }
    }

    private void removingValidation() {
        if (isEmpty()) {
            throw new IllegalArgumentException("There are no elements to be removed!");
        }
    }

    public void addFirst(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }
        this.size++;
    }

    public void addLast(int element) {
        Node newNode = new Node(element);

        if (isEmpty()) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }
        this.size++;
    }

    public int get(int index) {
        checkIndex(index);

        int result = 0;

        Node currentNode;
        if (index <= this.size / 2) {
            currentNode = this.head;

            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;

            for (int i = this.size - 1; i > index ; i--) {
                currentNode = currentNode.prev;
            }
        }
        result = currentNode.currentValue;
        return result;
    }

    public int removeFirst() {
        removingValidation();

        int removedElement = this.head.currentValue;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;

        return removedElement;
    }

    public int removeLast() {
        removingValidation();

        int removedElement = this.tail.currentValue;

        if (this.size == 1) {
            this.head = this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;

        return removedElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.currentValue);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        Node currentNode = this.head;

        int index = 0;

        while (currentNode != null) {
            array[index] = currentNode.currentValue;
            currentNode = currentNode.next;
            index++;
        }
        return array;
    }
}
