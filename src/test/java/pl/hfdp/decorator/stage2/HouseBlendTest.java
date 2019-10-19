package pl.hfdp.decorator.stage2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseBlendTest {

    private HouseBlend houseBlend;

    @Before
    public void setup() {
        houseBlend = new HouseBlend();
    }

    @Test
    public void cost() {
        houseBlend.setMilk(true);
        houseBlend.setMocha(true);
        houseBlend.setSoy(true);
        houseBlend.setWhip(true);

        Beverage beverage = new Beverage();
        beverage.setMilk(true);
        beverage.setMocha(true);
        beverage.setSoy(true);
        beverage.setWhip(true);
        assertEquals(houseBlend.cost(), "House Blend".hashCode() + beverage.cost());
    }
}