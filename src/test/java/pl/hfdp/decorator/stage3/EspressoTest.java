package pl.hfdp.decorator.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EspressoTest {

    private Espresso espresso;

    @Before
    public void setup() {
        espresso = new Espresso();
    }

    @Test
    public void getDescription() {
        assertEquals(espresso.getDescription(), "Espresso");
    }

    @Test
    public void cost() {
        assertEquals(espresso.cost(), 5.7, 0);
    }
}