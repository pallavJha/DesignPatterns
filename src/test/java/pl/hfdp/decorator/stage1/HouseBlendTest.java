package pl.hfdp.decorator.stage1;

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
    public void testGetDescription() {
        assertEquals(houseBlend.getDescription(), "House Blend");
    }

    @Test
    public void testGetCost() {
        assertEquals(10.5, houseBlend.cost(), 0);
    }
}