package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackTest {
    private Stack stack;
    private Stack emptyStack;

    @Before
    public void setUp() {
        stack = new Stack();
        emptyStack = new Stack();
        for (int i : new int[]{1, 2, 3, 4, 5}) {
            stack.push(i);
        }
    }

    @Test
    public void pop() {
        assertEquals(5, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void pop1() {
        try {
            emptyStack.pop();
        } catch (IllegalArgumentException i) {}
    }

    @Test
    public void peek() {
        assertEquals(5, stack.peek());
    }
}
