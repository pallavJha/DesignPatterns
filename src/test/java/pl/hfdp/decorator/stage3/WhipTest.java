package pl.hfdp.decorator.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WhipTest {

    private Whip whip;
    private Beverage espresso;

    @Before
    public void setup() {
        espresso = new Espresso();
        whip = new Whip(espresso);
    }

    @Test
    public void getDescription() {
        assertEquals("Espresso, Whip", whip.getDescription());
    }

    @Test
    public void cost() {
        assertEquals(whip.cost(), espresso.cost() + 1.5D, 0);
    }
}