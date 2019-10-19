package pl.hfdp.decorator.stage2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecafTest {

    private Decaf decaf;

    @Before
    public void setup() {
        decaf = new Decaf();
    }

    @Test
    public void cost() {
        decaf.setMilk();
        decaf.setMocha();
        decaf.setSoy();
        decaf.setWhip();
        assertEquals(15.23, decaf.cost() ,0);
    }
}