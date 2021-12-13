package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList list;

    public Queue() {
        list = new ImmutableLinkedList();
    }

    public Queue(Object[] objects) {
        list = new ImmutableLinkedList(objects);
    }

    public Object peek() {
        return list.getFirst();
    }

    public Object dequeue() {
        Object value = list.getFirst();
        list = list.removeFirst();
        return value;
    }

    public void enqueue(Object e) {
        list = list.addLast(e);
    }
}
