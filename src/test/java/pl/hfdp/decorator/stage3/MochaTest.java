package pl.hfdp.decorator.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MochaTest {

    private Mocha mocha;
    private Beverage houseBlend;

    @Before
    public void setup() {
        houseBlend = new HouseBlend();
        mocha = new Mocha(houseBlend);
    }

    @Test
    public void getDescription() {
        assertEquals("House Blend Coffee, Mocha", mocha.getDescription());
    }

    @Test
    public void cost() {
        assertEquals(mocha.cost(), houseBlend.cost() + 1.5D, 0);
    }
}