package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private int size;
    private Node first;
    private Node last;
    private Object[] objects;

    public ImmutableLinkedList(Object[] elements) {
        objects = Arrays.copyOf(elements, elements.length);
        size = elements.length;
        Node currNode = new Node(elements[0]);
        first = currNode;

        if (elements.length > 1) {
            for (int i = 1; i < elements.length; i++) {

                Node newNode = new Node(elements[i]);
                currNode.setNext(newNode);
                newNode.setPrevious(currNode);
                currNode = newNode;
                if (i == elements.length - 1) {
                    last = currNode;
                }
            }
        } else {
            last = currNode;
        }
    }


    public ImmutableLinkedList() {
        objects = new Object[0];
        size = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        Object[] newObj = Arrays.copyOf(objects, objects.length + 1);
        newObj[objects.length] = e;

        return new ImmutableLinkedList(newObj);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        Object[] newObj = new Object[objects.length + 1];

        for (int i = 0; i < index; i++) {
            newObj[i] = objects[i];
        }
        newObj[index] = e;
        if (index + 1 < newObj.length) {
            for(int j = index + 1; j < newObj.length; j++) {
                newObj[j] = objects[j - 1];
            }
        }
        return new ImmutableLinkedList(newObj);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        Object[] newObj = Arrays.copyOf(objects, objects.length + c.length);
        for (int i = 0; i < c.length; i++) {
            newObj[objects.length + i] = c[i];
        }
        return new ImmutableLinkedList(newObj);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        Object[] newObj = new Object[objects.length + c.length];

        for  (int i = 0; i < index; i++) {
            newObj[i] = objects[i];
        }

        for (int j = 0; j < c.length; j++) {
            newObj[index + j] = c[j];
        }

        // do we nedd + 1????
        if (newObj.length > c.length + index) {
            for (int k = index; index < objects.length; k++) {
                newObj[k + c.length] = objects[k];
            }
        }
        return new ImmutableLinkedList(newObj);
    }

    @Override
    public Object get(int index) {
        if (index > objects.length) {
            throw new IllegalArgumentException();
        }
        return objects[index];
    }

    @Override
    public ImmutableList remove(int index) {
        Object[] newObj = new Object[objects.length - 1];
        int i = 0;
        for (int j = 0; j < objects.length; j++) {
            if (j != index) {
                newObj[i] = objects[j];
                i += 1;
            }
        }
        return new ImmutableLinkedList(newObj);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= objects.length) {
            throw new IllegalArgumentException();
        }
        Object[] newObj = new Object[objects.length];
        newObj[index] = e;
        return new ImmutableLinkedList(newObj);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (objects.length == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(objects, objects.length);
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] newObj = new Object[objects.length +1];
        newObj[0] = e;

        for (int i = 0; i < objects.length; i++) {
            newObj[i + 1] = objects[i];
        }
        return new ImmutableLinkedList(newObj);
    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] newObj = Arrays.copyOf(objects, objects.length + 1);
        newObj[objects.length] = e;
        return new ImmutableLinkedList(newObj);
    }

    public Node getHead() {
        return first;
    }

    public Node getTail() {
        return last;
    }

    public Object getFirst() {
        return first.getValue();
    }

    public Object getLast() {
        return last.getValue();
    }

    public ImmutableLinkedList removeFirst() {

        // чи треба віднімати 1?
        Object[] newObj = Arrays.copyOfRange(objects, 1, objects.length - 1);
        return new ImmutableLinkedList(newObj);
    }

    public ImmutableLinkedList removeLast() {
        Object[] newObj = Arrays.copyOfRange(objects, 0, objects.length - 2);
        return new ImmutableLinkedList(newObj);
    }
}
