package pl.hfdp.decorator.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseBlendTest {

    private HouseBlend houseBlend;

    @Before
    public void setup() {
        houseBlend = new HouseBlend();
    }

    @Test
    public void getDescription() {
        assertEquals("House Blend Coffee", houseBlend.getDescription());
    }

    @Test
    public void cost() {
        assertEquals(houseBlend.cost(), 3.8, 0);
    }
}