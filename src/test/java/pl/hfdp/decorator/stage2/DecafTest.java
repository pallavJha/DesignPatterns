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

        Beverage beverage = new Beverage();
        beverage.setMilk();
        beverage.setMocha();
        beverage.setSoy();
        beverage.setWhip();
        assertEquals(decaf.cost(), "Decaf".hashCode() + beverage.cost());
    }
}