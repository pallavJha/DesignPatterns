package pl.hfdp.decorator.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DoubleMochaTest {

    private Mocha mocha;
    private Mocha doubleMocha;
    private Beverage houseBlend;

    @Before
    public void setup() {
        houseBlend = new HouseBlend();
        mocha = new Mocha(houseBlend);
        doubleMocha = new Mocha(mocha);
    }

    @Test
    public void getDescription() {
        assertEquals("House Blend Coffee, Mocha, Mocha", doubleMocha.getDescription());
    }

    @Test
    public void cost() {
        assertEquals(doubleMocha.cost(), houseBlend.cost() + 2 * 1.5D, 0);
    }
}