package workshopCustomDataStructures;

import java.util.function.Consumer;

public class CustomStack {

    private static class Node {
        private int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    private Node top;
    private int size;

    public void push(int element) {
        Node newNode = new Node(element);

        newNode.prev = top;
        top = newNode;

        this.size++;
    }

    public int pop() {
        ensureNotEmpty();

        int removedElement = top.element;

        top = top.prev;
        this.size--;

        return removedElement;
    }

    public int peek() {
        ensureNotEmpty();

        return top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }
    }

    private void ensureNotEmpty() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty!");
        }
    }
}
