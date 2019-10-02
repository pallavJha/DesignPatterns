package pl.hfdp.strategy.stage2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RubberDuckTest {

    private RubberDuck rubberDuck;

    @Before
    public void setUp() {
        rubberDuck = new RubberDuck();
    }

    @After
    public void tearDown() {
        rubberDuck = null;
    }

    @Test
    public void quack() {
        assertEquals("Quack!", rubberDuck.quack());
    }

    @Test
    public void swim() {
        assertEquals("Swim!", rubberDuck.swim());
    }

    @Test
    public void display() {
        assertEquals("Rubber duck is yellow!", rubberDuck.display());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void fly() {
        rubberDuck.fly();
    }
}