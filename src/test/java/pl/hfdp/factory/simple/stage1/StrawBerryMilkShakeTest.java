package pl.hfdp.factory.simple.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class StrawBerryMilkShakeTest {

    private StrawBerryMilkShake strawBerryMilkShake;
    private ByteArrayOutputStream stream;
    private PrintStream originalStream;

    @Before
    public void setUp() {
        strawBerryMilkShake = new StrawBerryMilkShake();
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
    }

    @After
    public void tearDown() {
        strawBerryMilkShake = null;
        System.setOut(originalStream);
    }

    @Test
    public void testAddMilk() {
        strawBerryMilkShake.addMilk();
        String content = stream.toString();
        assertEquals("Adding the milk...", content.trim());
        stream.reset();
    }

    @Test
    public void testAddIngredients() {
        strawBerryMilkShake.addIngredients();
        String content = stream.toString();
        assertEquals("Adding the ingredients... [Milk, Straw Berry]", content.trim());
        stream.reset();
    }

    @Test
    public void testBlend() {
        strawBerryMilkShake.blend();
        String content = stream.toString();
        assertEquals("Blending... [Milk, Straw Berry]", content.trim());
        stream.reset();
    }

    @Test
    public void testToString() {
        assertEquals("MilkShake{ingredients=[Milk, Straw Berry]}", strawBerryMilkShake.toString());
    }

    @Test
    public void name() {
        assertEquals("Strawberry Milk Shake", StrawBerryMilkShake.name());
    }
}