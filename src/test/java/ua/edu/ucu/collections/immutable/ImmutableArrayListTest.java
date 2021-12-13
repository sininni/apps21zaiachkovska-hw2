package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ImmutableArrayListTest extends TestCase {
    ImmutableArrayList emptyArr;
    ImmutableArrayList arr;

    @Before
    public void setUp() {
        emptyArr = new ImmutableArrayList();
        Object[] objects = new Object[3];
        objects[0] = "are";
        objects[1] = 23;
        objects[2] = 2.35;
        arr = new ImmutableArrayList(objects);
    }

    public void testAdd() {
        assertEquals(emptyArr.add("dead").toString(), "ImmutableArrayList{arr=[dead]}");
        assertEquals(arr.add("dead").toString(), "ImmutableArrayList{arr=[are, 23, 2.35, dead]}");
    }

    public void testIndexAdd() {
        assertEquals(arr.add(1, "balt").toString(), "ImmutableArrayList{arr=[are, balt, 23, 2.35]}");
        assertEquals(arr.add(3, "balt").toString(), "ImmutableArrayList{arr=[are, 23, 2.35, balt]}");
    }

//    @Test (expected = IllegalArgumentException.class)
//    public void testIndexAdd1() {
//        arr.add(5, 1);
//    }

    public void testAddAll() {
        Object[] obj = {1, "325"};
        assertEquals(arr.addAll(obj).toString(), "ImmutableArrayList{arr=[are, 23, 2.35, 1, 325]}");
        assertEquals(emptyArr.addAll(obj).toString(), "ImmutableArrayList{arr=[1, 325]}");
    }

    public void testTestAddAll() {
        Object[] obj = {1, "325"};
        assertEquals(arr.addAll(2, obj).toString(), "ImmutableArrayList{arr=[are, 23, 1, 325, 2.35]}");
        assertEquals(arr.addAll(0, obj).toString(), "ImmutableArrayList{arr=[1, 325, are, 23, 2.35]}");
        assertEquals(arr.addAll(3, obj).toString(), "ImmutableArrayList{arr=[are, 23, 2.35, 1, 325]}");
    }

    //    @Test (expected = IllegalArgumentException.class)
//    public void testIndexAdd1() {
//        arr.add(5, 1);
//    }

    public void testGet() {
        assertEquals(arr.get(1), 23);
    }

    //    @Test (expected = IllegalArgumentException.class)
//    public void testIndexAdd1() {
//        arr.add(5, 1);
//    }

    public void testRemove() {
        assertEquals(arr.remove(2).toString(), "ImmutableArrayList{arr=[are, 23]}");
    }

//    public void testSet() {
//        assertEquals(arr.set(1, "key"), "ImmutableArrayList{arr=[are, key, 2.35]}");
//    }

    public void testIndexOf() {
        assertEquals(arr.indexOf(23), 1);
        assertEquals(arr.indexOf(2323), -1);
    }

    public void testSize() {
        assertEquals(emptyArr.size(), 0);
        assertEquals(arr.size(), 3);
    }

    public void testClear() {
        assertEquals(arr.clear().toString(), "ImmutableArrayList{arr=[]}");
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
}