package pl.hfdp.decorator.stage1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecalWithSoyAndMochaTest {

    private DecalWithSoyAndMocha coffee;

    @Before
    public void setup() {
        coffee = new DecalWithSoyAndMocha();
    }

    @Test
    public void testGetDescription() {
        assertEquals(coffee.getDescription(), "Decal With Soy And Mocha");
    }

    @Test
    public void testGetCost() {
        assertEquals(9.44, coffee.cost(), 0);
    }
}