package pl.hfdp.decorator.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseBlendWithMochaAndStreamedMilkTest {

    private HouseBlendWithMochaAndStreamedMilk houseBlendWithMochaAndStreamedMilk;

    @Before
    public void setup() {
        houseBlendWithMochaAndStreamedMilk = new HouseBlendWithMochaAndStreamedMilk();
    }

    @Test
    public void testGetDescription() {
        assertEquals(houseBlendWithMochaAndStreamedMilk.getDescription(), "House Blend With Mocha And Streamed Milk");
    }

    @Test
    public void testGetCost() {
        assertEquals(houseBlendWithMochaAndStreamedMilk.getDescription().hashCode(), houseBlendWithMochaAndStreamedMilk.getCost());
    }
}