package pl.hfdp.decorator.stage2;

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
    public void cost() {
        espresso.setMilk();
        espresso.setMocha();
        espresso.setSoy();
        espresso.setWhip();

        Beverage beverage = new Beverage();
        beverage.setMilk();
        beverage.setMocha();
        beverage.setSoy();
        beverage.setWhip();
        assertEquals(7.55, espresso.cost(), 0);
    }

}