package workshopCustomDataStructures;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {

    private int[] data;
    private int size;

    public SmartArray() {
        this.data = new int[1];
        this.size = 0;
    }

    public void add(int element) {
        if (size == data.length) {
            data = grow();
        }
        this.data[size++] = element;
    }

    public int get(int index) {
        ensureIndex(index);

        return this.data[index];
    }

    public int size() {
        return this.size;
    }

    public int remove(int index) {
        ensureIndex(index);

        int removedElement = get(index);

        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;
        this.size--;

        if (this.size == this.data.length / 4) {
            this.data = shrink();
        }

        return removedElement;
    }

    public boolean contains(int element) {
        return Arrays.stream(this.data, 0, this.size).anyMatch(e -> e == element);
    }

    public void add(int index, int element) {
        int lastElement = this.data[this.size - 1];

        for (int i = this.size - 1; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = element;

        add(lastElement);
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    private int[] grow() {
        int newLength = this.data.length * 2;
        int[] newData = new int[newLength];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private int[] shrink() {
        int newLength = this.data.length / 2;
        int[] newData = new int[newLength];

        System.arraycopy(this.data, 0, newData, 0, this.data.length);

        return newData;
    }

    private void ensureIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bounds for length %d!", index, this.size));
        }
    }
}
