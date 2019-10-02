package pl.hfdp.strategy.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlyWithWingsTest {

    private FlyWithWings flyWithWings;

    @Before
    public void before() {
        flyWithWings = new FlyWithWings();
    }

    @Test
    public void fly() {
        assertEquals("fly with two wings", flyWithWings.fly());
    }
}