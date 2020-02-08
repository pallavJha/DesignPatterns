package pl.hfdp.component.stage2;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

public class HTMLCompositeElementTest {

    private HTMLCompositeElement element;

    @Before
    public void setUp() {
        element = new HTMLCompositeElement();
    }

    @Test
    public void getType() {
        element.setType("ABC");
        TestCase.assertEquals("ABC", element.getType());
    }

    @Test
    public void setType() {
        element.setType("ABC");
        TestCase.assertEquals("ABC", element.getType());
    }

    @Test
    public void iterator() {
        HTMLCompositeElement element1 = new HTMLCompositeElement();
        HTMLCompositeElement element2 = new HTMLCompositeElement();
        element.addElement(element1);
        element.addElement(element2);
        Iterator<HTMLComponent> elementIterator = element.iterator();
        TestCase.assertEquals(element1, elementIterator.next());
        TestCase.assertEquals(element2, elementIterator.next());
    }

    @Test
    public void addElement() {
        HTMLCompositeElement element1 = new HTMLCompositeElement();
        HTMLCompositeElement element2 = new HTMLCompositeElement();
        element.addElement(element1);
        element.addElement(element2);
        Iterator<HTMLComponent> elementIterator = element.iterator();
        TestCase.assertEquals(element1, elementIterator.next());
        TestCase.assertEquals(element2, elementIterator.next());
    }

    @Test
    public void getText() {
        HTMLCompositeElement element1 = new HTMLCompositeElement();
        element1.setText("A");

        HTMLCompositeElement element12 = new HTMLCompositeElement();
        element12.setText("B");

        HTMLCompositeElement element123 = new HTMLCompositeElement();
        element123.setText("C");

        HTMLLeafElement element2 = new HTMLLeafElement();
        element2.setText("D");

        element1.addElement(element12);
        element12.addElement(element123);
        element1.addElement(element2);

        TestCase.assertEquals("ABCD", element1.getText());
    }

    @Test
    public void setText() {
    }
}