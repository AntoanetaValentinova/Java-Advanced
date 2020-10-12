package CustomList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void addElement(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        if (validateIndex(index)) {
            return this.elements.remove(index);
        }
        return null;
    }

    public boolean contains(T element) {
        if (this.elements.contains(element)) {
            return true;
        }
        return false;
    }

    public void swap(int indexOne, int indexTwo) {
        if (validateIndex(indexOne) && validateIndex((indexTwo))) {
            T temp = this.elements.get(indexOne);
            this.elements.set(indexOne, this.elements.get(indexTwo));
            this.elements.set(indexTwo, temp);
        }
    }

    public int countGreaterThan(T element) {
        List<T> newList = new ArrayList<>();
        elements
                .stream()
                .forEach(e -> {
                    if (element.compareTo(e) < 0) {
                        newList.add(e);
                    }
                });
        return newList.size();
    }

    public T getMax() {
        return elements.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public T getMin() {
        return elements.stream()
                .min(Comparator.naturalOrder())
                .get();
    }

    public List<T> getElements() {
        return elements;
    }

    public boolean validateIndex(int index) {
        if (index >= 0 && index < this.elements.size()) {
            return true;
        }
        return false;
    }
}
