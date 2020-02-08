package pl.hfdp.component.stage2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract class HTMLComponent {

    private String type;

    public String getText() {
        throw new UnsupportedOperationException("The Element cannot have text.");
    }

    public void setText(String text) {
        throw new UnsupportedOperationException("The Element cannot have text.");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addElement(HTMLComponent element) {
        throw new UnsupportedOperationException("The Element cannot have children nodes.");
    }

    public Iterator<HTMLComponent> iterator() {
        throw new UnsupportedOperationException("The Element cannot have children nodes.");
    }
}

class HTMLCompositeElement extends HTMLComponent {

    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    private List<HTMLComponent> elements = new ArrayList<>();

    public void addElement(HTMLComponent element) {
        elements.add(element);
    }

    public Iterator<HTMLComponent> iterator() {
        return elements.iterator();
    }

    public String getText() {
        StringBuilder htmlText = new StringBuilder(this.text);
        Iterator<HTMLComponent> iter = this.iterator();
        while (iter.hasNext()) {
            htmlText.append(iter.next().getText());
        }
        return htmlText.toString();
    }
}

class HTMLLeafElement extends HTMLComponent {

    private String text;

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    public Iterator<HTMLComponent> iterator() {
        return new BlankIterator<>();
    }
}

class BlankIterator<HTMLComponent> implements Iterator<HTMLComponent> {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public HTMLComponent next() {
        return null;
    }
}


class HTMLPage {

    private HTMLComponent rootElement;

    public HTMLPage(HTMLComponent rootElement) {
        this.rootElement = rootElement;
    }

    public String text() {
        return rootElement.getText();
    }

}
