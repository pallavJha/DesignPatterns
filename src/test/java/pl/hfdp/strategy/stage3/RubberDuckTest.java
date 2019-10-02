package pl.hfdp.strategy.stage3;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RubberDuckTest {

    private RubberDuck rubberDuck;

    @Before
    public void before() {
        rubberDuck = new RubberDuck(new FlyNoWay());
    }

    @After
    public void tearDown() {
        rubberDuck = null;
    }

    @Test
    public void testQuack() {
        assertEquals("Quack!", rubberDuck.quack());
    }

    @Test
    public void testSwim() {
        assertEquals("Swim!", rubberDuck.swim());
    }

    @Test
    public void testDisplay() {
        assertEquals("Rubber duck is yellow!", rubberDuck.display());
    }

    @Test
    public void testPerformFly() {
        assertEquals("cannot fly", rubberDuck.performFly());
    }
}