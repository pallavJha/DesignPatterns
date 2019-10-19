package pl.hfdp.decorator.stage2;

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
    public void cost() {
        darkRoast.setMilk();
        darkRoast.setMocha();
        darkRoast.setSoy();
        darkRoast.setWhip();
        assertEquals(9.6, darkRoast.cost(), 0);
    }
}