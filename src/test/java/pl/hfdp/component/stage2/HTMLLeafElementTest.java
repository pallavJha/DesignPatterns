package pl.hfdp.component.stage2;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class HTMLLeafElementTest {

    private HTMLLeafElement leafElement;

    @Before
    public void setup() {
        leafElement = new HTMLLeafElement();
    }

    @Test
    public void getText() {
        leafElement.setText("ABC");
        TestCase.assertEquals("ABC", leafElement.getText());
    }

    @Test
    public void setText() {
        leafElement.setText("ABC");
        TestCase.assertEquals("ABC", leafElement.getText());
    }

    @Test
    public void getType() {
        leafElement.setType("ABC");
        TestCase.assertEquals("ABC", leafElement.getType());
    }

    @Test
    public void setType() {
        leafElement.setType("ABC");
        TestCase.assertEquals("ABC", leafElement.getType());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addElement() {
        leafElement.addElement(new HTMLLeafElement());
    }

    @Test
    public void iterator() {
        Iterator<HTMLComponent> iter = leafElement.iterator();
        TestCase.assertTrue(iter instanceof BlankIterator);
    }
}