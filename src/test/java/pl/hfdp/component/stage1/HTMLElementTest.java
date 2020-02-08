package pl.hfdp.component.stage1;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import pl.hfdp.component.stage1.HTMLElement;

public class HTMLElementTest {

    private HTMLElement element;

    @Before
    public void setUp() {
        element = new HTMLElement();
    }

    @Test
    public void getText() {
        element.setText("ABC");
        TestCase.assertEquals("ABC", element.getText());
    }

    @Test
    public void setText() {
        element.setText("ABC");
        TestCase.assertEquals("ABC", element.getText());
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
}