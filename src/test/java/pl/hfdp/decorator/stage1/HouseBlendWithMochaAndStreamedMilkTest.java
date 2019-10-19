package pl.hfdp.decorator.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseBlendWithMochaAndStreamedMilkTest {

    private HouseBlendWithMochaAndStreamedMilk coffee;

    @Before
    public void setup() {
        coffee = new HouseBlendWithMochaAndStreamedMilk();
    }

    @Test
    public void testGetDescription() {
        assertEquals(coffee.getDescription(), "House Blend With Mocha And Streamed Milk");
    }

    @Test
    public void testGetCost() {
        assertEquals(11.45, coffee.getCost(), 0);
    }
}