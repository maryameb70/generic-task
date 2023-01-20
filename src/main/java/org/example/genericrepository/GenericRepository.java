package org.example.genericrepository;

import java.util.Arrays;

public class GenericRepository<T> {
    private Object[] elements;
    private int emptyIndex = 0;

    public GenericRepository(GenericRepository<T> repo) {
        //
    }
    public GenericRepository() {
        elements = new Object[5];
    }

    public GenericRepository(int size) {
        elements = new Object[size];
    }

    private void extendArray() {
        Object[] resizeArray = new Object[elements.length + 5];
        for (int i = 0; i < elements.length; i++) {
            resizeArray[i] = elements[i];
        }
        this.elements = resizeArray;
    }

    public void add(T element) {
        if (emptyIndex >= elements.length) {
            extendArray();
            elements[emptyIndex++] = element;
        } else {
            elements[emptyIndex++] = element;
        }
    }

    public int findFirst(T element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (isIndexInvalid(index)) {
            return;
        }
        elements[index] = null;
        emptyIndex = index;
        shiftArray(emptyIndex);
    }

    private void shiftArray(int index) {
        for (int i = emptyIndex; i < elements.length; i++) {

            if (i+1>= elements.length) {
                elements[i] = null;
            }
            else {
                elements[i] = elements[i + 1];
            }
        }
    }

    private void shiftArray() {
        Object[] objects = new Integer[this.elements.length];
        int objectsIndex = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                objects[objectsIndex++] = elements[i];
            }
        }
        this.elements = objects;
    }

    public void remove(T element) {
        int i = findFirst(element);
        if (i == -1) {
            return;
        }
        remove(i);
    }

    public void removeAll(T element) {
        Object temp = elements[0];
        int count = 1;
        Arrays.sort(elements);
        for (int i = 1; i < elements.length; i++) {
            if (temp == elements[i]) {
                count++;
            } else {
                temp = elements[i];
            }
        }
        removeElementCount(element, count);
    }

    private void removeElementCount(T element, int count) {
        for (int i = 0; i < count; i++) {
            remove(element);
        }
    }

    public void clear() {
        elements = new Object[5];
    }

    private boolean isIndexInvalid(int index) {
        if (index < 0 || index >= elements.length) {
            return true;
        }
        return false;
    }

    public void printAll() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }
    }
}
