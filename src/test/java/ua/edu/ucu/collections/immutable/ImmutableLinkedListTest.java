package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;

public class ImmutableLinkedListTest extends TestCase {
    ImmutableLinkedList emptyArr;
    ImmutableLinkedList arr;

    @Before
    public void setUp() {
        emptyArr = new ImmutableLinkedList();
        Object[] objects = new Object[3];
        objects[0] = "are";
        objects[1] = 23;
        objects[2] = 2.35;
        arr = new ImmutableLinkedList(objects);
    }

    public void testAdd() {
        assertEquals(emptyArr.add("dead").toString(), "ImmutableLinkedList{objects=[dead]}");
        assertEquals(arr.add("dead").toString(), "ImmutableLinkedList{objects=[are, 23, 2.35, dead]}");
    }

    public void testIndexAdd() {
        assertEquals(arr.add(1, "balt").toString(), "ImmutableLinkedList{objects=[are, balt, 23, 2.35]}");
        assertEquals(arr.add(3, "balt").toString(), "ImmutableLinkedList{objects=[are, 23, 2.35, balt]}");
    }

    public void testAddAll() {
        Object[] obj = {1, "325"};
        assertEquals(arr.addAll(obj).toString(), "ImmutableLinkedList{objects=[are, 23, 2.35, 1, 325]}");
        assertEquals(emptyArr.addAll(obj).toString(), "ImmutableLinkedList{objects=[1, 325]}");
    }

    public void testTestAddAll() {
        Object[] obj = {1, "325"};
        assertEquals(arr.addAll(2, obj).toString(), "ImmutableLinkedList{objects=[are, 23, 1, 325, 2.35]}");
        assertEquals(arr.addAll(0, obj).toString(), "ImmutableLinkedList{objects=[1, 325, are, 23, 2.35]}");
        assertEquals(arr.addAll(3, obj).toString(), "ImmutableLinkedList{objects=[are, 23, 2.35, 1, 325]}");
    }

    public void testGet() {
        assertEquals(arr.get(1), 23);
    }

    public void testRemove() {
        assertEquals(arr.remove(2).toString(), "ImmutableLinkedList{objects=[are, 23]}");
    }

    public void testSet() {
        assertEquals(arr.set(1, "key").toString(), "ImmutableLinkedList{objects=[are, key, 2.35]}");
    }

    public void testIndexOf() {
        assertEquals(arr.indexOf(23), 1);
        assertEquals(arr.indexOf(2323), -1);
    }

    public void testSize() {
        assertEquals(emptyArr.size(), 0);
        assertEquals(arr.size(), 3);
    }

    public void testClear() {
        assertEquals(arr.clear().toString(), "ImmutableLinkedList{objects=[]}");
    }

    public void testIsEmpty() {
        assertTrue(emptyArr.isEmpty());
        assertFalse(arr.isEmpty());
    }

    public void testToArray() {
        Object[] objs = {"are", 23, 2.35};
        assertEquals(arr.toArray()[0], objs[0]);
        assertEquals(arr.toArray()[1], objs[1]);
        assertEquals(arr.toArray()[2], objs[2]);
    }

    public void testAddFirst() {
        assertEquals(emptyArr.addFirst(21).toString(), "ImmutableLinkedList{objects=[21]}");
        assertEquals(arr.addFirst(21).toString(), "ImmutableLinkedList{objects=[21, are, 23, 2.35]}");
    }

    public void testAddLast() {
        assertEquals(emptyArr.addLast(21).toString(), "ImmutableLinkedList{objects=[21]}");
        assertEquals(arr.addLast(21).toString(), "ImmutableLinkedList{objects=[are, 23, 2.35, 21]}");
    }

    public void testGetHead() {
        assertEquals(emptyArr.getHead(), null);
        assertEquals(arr.getHead().getValue(), "are");
    }

    public void testGetTail() {
        assertEquals(emptyArr.getTail(), null);
        assertEquals(arr.getTail().getValue(), 2.35);
    }

    public void testGetFirst() {
        assertEquals(arr.getFirst(), "are");
    }

    public void testGetLast() {
        assertEquals(arr.getLast(), 2.35);
    }

    public void testRemoveFirst() {
        assertEquals(arr.removeFirst().toString(),"ImmutableLinkedList{objects=[23, 2.35]}");
        assertEquals(emptyArr.removeFirst().toString(),"ImmutableLinkedList{objects=[]}");
    }

    public void testRemoveLast() {
        assertEquals(arr.removeLast().toString(),"ImmutableLinkedList{objects=[are, 23]}");
        assertEquals(emptyArr.removeLast().toString(),"ImmutableLinkedList{objects=[]}");
    }
}