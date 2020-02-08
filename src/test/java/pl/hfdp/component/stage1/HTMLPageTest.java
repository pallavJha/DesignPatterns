package pl.hfdp.component.stage1;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import pl.hfdp.component.stage1.HTMLElement;
import pl.hfdp.component.stage1.HTMLPage;

import java.util.Iterator;

public class HTMLPageTest {

    private HTMLPage page;

    @Before
    public void setUp() {
        page = new HTMLPage();
    }

    @Test
    public void addElement() {
        HTMLElement element1 = new HTMLElement();
        HTMLElement element2 = new HTMLElement();
        page.addElement(element1);
        page.addElement(element2);
        Iterator<HTMLElement> elementIterator = page.iterator();
        TestCase.assertEquals(element1, elementIterator.next());
        TestCase.assertEquals(element2, elementIterator.next());
    }

    @Test
    public void setElements() {
        HTMLElement element1 = new HTMLElement();
        HTMLElement element2 = new HTMLElement();
        page.addElement(element1);
        page.addElement(element2);
        Iterator<HTMLElement> elementIterator = page.iterator();
        TestCase.assertEquals(element1, elementIterator.next());
        TestCase.assertEquals(element2, elementIterator.next());
    }
}