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
        houseBlend.setMilk();
        houseBlend.setMocha();
        houseBlend.setSoy();
        houseBlend.setWhip();

        Beverage beverage = new Beverage();
        beverage.setMilk();
        beverage.setMocha();
        beverage.setSoy();
        beverage.setWhip();
        assertEquals(houseBlend.cost(), "House Blend".hashCode() + beverage.cost());
    }
}