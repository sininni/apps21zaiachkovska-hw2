package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private Object[] arr;

    public ImmutableArrayList(Object[] elements) {
        arr = elements;
    }

    public ImmutableArrayList() {
        arr = new Object[0];
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newArr = new Object[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        newArr[arr.length] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (index > arr.length) {
            throw new IllegalArgumentException();
        }

        Object[] newArr = new Object[arr.length + 1];

        for  (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        newArr[index] = e;

        if (newArr.length > index + 1) {
            for (int j = index + 1; j < newArr.length; j++) {
                newArr[j] = arr[j - 1];
            }
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newArr = Arrays.copyOf(arr, arr.length + c.length);
        for (int i = 0; i < c.length; i++) {
            newArr[arr.length + i] = c[i];
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index >= arr.length) {
            throw new IllegalArgumentException();
        }
        Object[] newArr = new Object[arr.length + c.length];

        for  (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        for (int j = 0; j < c.length; j++) {
                newArr[index + j] = c[j];
        }

        if (newArr.length > c.length + index) {
            for (int k = index; k < arr.length; k++) {
                newArr[k + c.length] = arr[k];
            }
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public Object get(int index) {
        if (arr.length == 0 || index >= arr.length) {
            throw new IllegalArgumentException();
        }
        return arr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= arr.length) {
            throw new IllegalArgumentException();
        }
        Object[] newArr = new Object[arr.length - 1];
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (j != index) {
                newArr[i] = arr[j];
                i += 1;
            }
        }
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index < arr.length) {
            Object[] newArr = Arrays.copyOf(arr, arr.length);
            newArr[index] = e;
            return new ImmutableArrayList(newArr);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return arr.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (arr.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arr, arr.length);
    }

    @Override
    public String toString() {
        return "ImmutableArrayList{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }
}
