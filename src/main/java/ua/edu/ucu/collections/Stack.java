package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList list;
    public Stack() {
        list = new ImmutableLinkedList();
    }

    public Stack(Object[] objects) {
        list = new ImmutableLinkedList(objects);
    }

    public void push(Object e) {
        list.addLast(e);
    }

    public Object pop() {
        Object value = list.getLast();
        list = list.removeLast();
        return value;
    }

    public Object peek() {
        return list.getFirst();
    }
}
