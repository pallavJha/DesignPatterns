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
        espresso.setMilk(true);
        espresso.setMocha(true);
        espresso.setSoy(true);
        espresso.setWhip(true);

        Beverage beverage = new Beverage();
        beverage.setMilk(true);
        beverage.setMocha(true);
        beverage.setSoy(true);
        beverage.setWhip(true);
        assertEquals(espresso.cost(), "Espresso".hashCode() + beverage.cost());
    }

}