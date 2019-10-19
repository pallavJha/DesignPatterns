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

        assertEquals(14.5, houseBlend.cost(), 0);
    }
}