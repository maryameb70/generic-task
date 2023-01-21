package org.example.genericrepository;

import org.example.base.BaseClass;

import java.util.Arrays;

public class GeneralRepositoryImpl<T> implements GeneralRepository<T> {
    private BaseClass<T>[] elements;
    private int emptyIndex = 0;

    public GeneralRepositoryImpl() {
        this.elements = new BaseClass[5];
    }

    public GeneralRepositoryImpl(int size) {
        this.elements = new BaseClass[size];
    }

    public GeneralRepositoryImpl(GeneralRepositoryImpl<T> repo) {
        this.elements = repo.elements;
    }

    private void extendArray() {
        BaseClass[] resizeArray = new BaseClass[elements.length + 5];
        for (int i = 0; i < elements.length; i++) {
            resizeArray[i] = elements[i];
        }
        this.elements = resizeArray;
    }

    @Override
    public void add(BaseClass<T> element) {
        if (emptyIndex >= elements.length) {
            extendArray();
        }
        elements[emptyIndex++] = element;
    }

    public T get(int index) {
        if (isIndexInvalid(index)) return null;
        return (T) elements[index].getId();
    }

    @Override
    public T getById(T id) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].getId().equals(id)) {
                return (T) elements[i].getId();
            }
        }
        return null;
    }

    public void update(int index, BaseClass<T> element) {
        if (isIndexInvalid(index)) {
            return;
        }
        elements[index] = element;
    }

    public void remove(int index) {
        if (isIndexInvalid(index)) {
            return;
        }
        elements[index] = null;
        emptyIndex = index;
        shiftArray();
    }

    private void shiftArray() {
        for (int i = emptyIndex; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
    }

    public int findFirst(T element) {
        if (element == null) {
            return -1;
        }
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].getId().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int findFirstById(T id) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null && elements[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeByElement(T element) {
        int i = findFirst(element);
        if (i == -1) {
            return;
        }
        remove(i);
    }

    private boolean isIndexInvalid(int index) {
        if (index < 0 || index >= elements.length) {
            return true;
        }
        return false;
    }

    public void clear() {
        elements = new BaseClass[5];
    }

    @Override
    public void printAll() {
        for (BaseClass<T> element : elements) {
            if (element != null) {
                System.out.println(element.getId());
            }
        }
    }
}
