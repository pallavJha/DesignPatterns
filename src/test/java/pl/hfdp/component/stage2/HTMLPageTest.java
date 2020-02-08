package pl.hfdp.component.stage2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HTMLPageTest {

    private HTMLPage page;

    @Test
    public void text() {
        HTMLLeafElement leafElement = new HTMLLeafElement();
        leafElement.setText("ABC");
        page = new HTMLPage(leafElement);
        assertEquals("ABC", page.text());
    }
}