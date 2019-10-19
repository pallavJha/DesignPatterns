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
        darkRoast.setMilk(true);
        darkRoast.setMocha(true);
        darkRoast.setSoy(true);
        darkRoast.setWhip(true);

        Beverage beverage = new Beverage();
        beverage.setMilk(true);
        beverage.setMocha(true);
        beverage.setSoy(true);
        beverage.setWhip(true);
        assertEquals(darkRoast.cost(), "Dark Roast".hashCode() + beverage.cost());
    }
}