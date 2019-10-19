package pl.hfdp.decorator.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DarkRoastTest {

    private DarkRoast darkRoast;

    @Before
    public void setup() {
        darkRoast = new DarkRoast();
    }

    @Test
    public void testGetDescription() {
        assertEquals(darkRoast.getDescription(), "Dark Roast");
    }

    @Test
    public void testGetCost() {
        assertEquals(5.6, darkRoast.getCost(), 0);
    }
}