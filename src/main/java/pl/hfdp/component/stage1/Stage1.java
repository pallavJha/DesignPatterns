package pl.hfdp.component.stage1;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class HTMLPage {

    private List<HTMLElement> elements = new ArrayList<>();

    public void addElement(HTMLElement element) {
        elements.add(element);
    }

    public Iterator<HTMLElement> iterator() {
        return elements.iterator();
    }
}

class HTMLElement {

    private String text;

    private String type;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}