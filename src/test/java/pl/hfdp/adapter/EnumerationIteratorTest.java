package pl.hfdp.adapter;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.*;

public class EnumerationIteratorTest {

    private EnumerationIterator<Integer> enumerationIterator;

    @Before
    public void setup() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        enumerationIterator = new EnumerationIterator<>(stack.iterator());
    }

    @Test
    public void hasMoreElements() {
        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(1, (int) enumerationIterator.nextElement());

        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(2, (int) enumerationIterator.nextElement());

        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(3, (int) enumerationIterator.nextElement());

        assertFalse(enumerationIterator.hasMoreElements());
    }

    @Test
    public void nextElement() {
        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(1, (int) enumerationIterator.nextElement());

        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(2, (int) enumerationIterator.nextElement());

        assertTrue(enumerationIterator.hasMoreElements());
        assertEquals(3, (int) enumerationIterator.nextElement());

        assertFalse(enumerationIterator.hasMoreElements());
    }
}