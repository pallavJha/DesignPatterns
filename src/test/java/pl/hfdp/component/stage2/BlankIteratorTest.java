package pl.hfdp.component.stage2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class BlankIteratorTest {

    private BlankIterator iterator;

    @Before
    public void setUp() {
        iterator = new BlankIterator();
    }

    @Test
    public void next() {
        assertNull(iterator.next());
    }

    @Test
    public void hasNext() {
        assertFalse(iterator.hasNext());
    }
}