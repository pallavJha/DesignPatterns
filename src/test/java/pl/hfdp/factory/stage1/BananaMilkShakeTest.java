package pl.hfdp.factory.stage1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class BananaMilkShakeTest {

    private BananaMilkShake bananaMilkShake;
    private ByteArrayOutputStream stream;
    private PrintStream originalStream;

    @Before
    public void setUp() {
        bananaMilkShake = new BananaMilkShake();
        originalStream = System.out;
        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
    }

    @After
    public void tearDown() {
        bananaMilkShake = null;
        System.setOut(originalStream);
    }

    @Test
    public void testAddMilk() {
        bananaMilkShake.addMilk();
        String content = stream.toString();
        assertEquals("Adding the milk...", content.trim());
        stream.reset();
    }

    @Test
    public void testAddIngredients() {
        bananaMilkShake.addIngredients();
        String content = stream.toString();
        assertEquals("Adding the ingredients... [Milk, Banana]", content.trim());
        stream.reset();
    }

    @Test
    public void testBlend() {
        bananaMilkShake.blend();
        String content = stream.toString();
        assertEquals("Blending... [Milk, Banana]", content.trim());
        stream.reset();
    }

    @Test
    public void testToString() {
        assertEquals("MilkShake{ingredients=[Milk, Banana]}", bananaMilkShake.toString());
    }

    @Test
    public void name() {
        assertEquals("Banana Milk Shake", BananaMilkShake.name());
    }
}