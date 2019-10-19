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
        decaf.setMilk(true);
        decaf.setMocha(true);
        decaf.setSoy(true);
        decaf.setWhip(true);

        Beverage beverage = new Beverage();
        beverage.setMilk(true);
        beverage.setMocha(true);
        beverage.setSoy(true);
        beverage.setWhip(true);
        assertEquals(decaf.cost(), "Decaf".hashCode() + beverage.cost());
    }
}