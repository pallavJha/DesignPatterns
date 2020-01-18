package pl.hfdp.adapter;

import org.junit.Before;
import org.junit.Test;

import java.util.Stack;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class IteratorEnumerationTest {

    private IteratorEnumeration<Integer> iteratorEnumeration;

    @Before
    public void setUp() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        iteratorEnumeration = new IteratorEnumeration<>(stack.elements());
    }

    @Test
    public void hasNext() {
        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(1, (int) iteratorEnumeration.next());

        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(2, (int) iteratorEnumeration.next());

        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(3, (int) iteratorEnumeration.next());

        assertFalse(iteratorEnumeration.hasNext());
    }

    @Test
    public void next() {
        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(1, (int) iteratorEnumeration.next());

        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(2, (int) iteratorEnumeration.next());

        assertTrue(iteratorEnumeration.hasNext());
        assertEquals(3, (int) iteratorEnumeration.next());

        assertFalse(iteratorEnumeration.hasNext());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void remove() {
        iteratorEnumeration.remove();
    }
}