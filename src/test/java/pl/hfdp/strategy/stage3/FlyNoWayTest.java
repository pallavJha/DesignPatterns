package pl.hfdp.strategy.stage3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlyNoWayTest {

    private FlyNoWay flyNoWay;

    @Before
    public void before() {
        flyNoWay = new FlyNoWay();
    }

    @Test
    public void fly() {
        assertEquals("cannot fly", flyNoWay.fly());
    }
}