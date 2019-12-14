package pl.hfdp.factory.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class ChocolateMilkShakeTest {

    private ChocolateMilkShake chocolateMilkShake;
    private ByteArrayOutputStream stream;
    private PrintStream originalStream;

    @Before
    public void setUp() {
        chocolateMilkShake = new ChocolateMilkShake();
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
    }

    @After
    public void tearDown() {
        chocolateMilkShake = null;
        System.setOut(originalStream);
    }

    @Test
    public void testAddMilk() {
        chocolateMilkShake.addMilk();
        String content = stream.toString();
        assertEquals("Adding the milk...", content.trim());
        stream.reset();
    }

    @Test
    public void testAddIngredients() {
        chocolateMilkShake.addIngredients();
        String content = stream.toString();
        assertEquals("Adding the ingredients... [Milk, Chocolate]", content.trim());
        stream.reset();
    }

    @Test
    public void testBlend() {
        chocolateMilkShake.blend();
        String content = stream.toString();
        assertEquals("Blending... [Milk, Chocolate]", content.trim());
        stream.reset();
    }

    @Test
    public void testToString() {
        assertEquals("MilkShake{ingredients=[Milk, Chocolate]}", chocolateMilkShake.toString());
    }

    @Test
    public void name() {
        assertEquals("Chocolate Milk Shake", ChocolateMilkShake.name());
    }
}