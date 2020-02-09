In this tutorial we'll be learning **Component Design Pattern**.

> Note: Make sure to go through the code comments as well. It'll help you understand the concept better.

We'll be creating a very simple HTML viewer while learning Component Design Pattern.

In an HTML document there are multiple elements. These elements are classified into tags.
There are multiple tags, like, _\<p\>_ or _\<table\>_.

The web developer creates an HTML document that contains these HTML element. Then the web developer reads the HTML content
and paints the output on the page. A very simple HTML element can be represented using the following class.

```java
class HTMLElement {

    // This field contains the text body of the HTML element.
    private String text;

    // This field represents the HTML type , like, tr or td.
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
```

This HTMLElement contains two fields:
1. Text: This will keep the textual data of the field.
2. Type: The actual type of the HTML element.

For example, the following HTML element:
```
<p>
    This world is a very beautiful place.
</p>
```
can be converted to an HTMLElement object through the following code:
```java
HTMLElement paragraph = new HTMLElement();
paragraph.setType("p");
paragraph.setText("This world is a very beautigul place.");
```

An then we can create a HTML page class that'll hold all these HTML elements:
```java
class HTMLPage {

    private List<HTMLElement> elements = new ArrayList<>();

    public void addElement(HTMLElement element) {
        elements.add(element);
    }

    public Iterator<HTMLElement> iterator() {
        return elements.iterator();
    }
}
```
This Page class has a list of HTML elements. It also returns an iterator if the client wants to go through the HTML
elements. Once the iterator is available then all the elements can be accessed and the `text()` method can called to
display the content for that HTML element.

```java
HTMLElement paragraph = new HTMLElement();
paragraph.setType("p");
paragraph.setText("This world is a very beautigul place.");

HTMLElement div = new HTMLElement();
paragraph.setType("div");
paragraph.setText("Can it be made any more beautiful?");

page.addElement(paragraph);
page.addElement(div);

Iterator<HTMLElement> elementIterator = page.iterator();
while (elementIterator.hasNext()) {
    System.out.println(elementIteratir.next().text());
} 
```

Our HTML parser is doing a fine job. But can it handle the following HTML?
```html
<div>
    <div>
        <p>Paragraph 1</p>
        <p>Paragraph 2</p>
        <p>Paragraph 3</p>
    </div>
    <div>
        <div>
            <p>Paragraph 1</p>
            <p>Paragraph 2</p>
            <p>Paragraph 3</p>
         </div>
        <p>Paragraph 2</p>
        <p>Paragraph 3</p>
    </div>
</div>
```
<!-- Insert Image here -->


Well it cannot anymore. Why? Because every HTML element is behaving like a HTML Page in itself.
An HTML element can have multiple children or it may have no children. 

This structure is now converted to an HTML tree(or DOM tree) with the HTML elements having no children becoming the leaf
elements of the tree.

One point to note here it that the output of the `text()` method for:
```html
<div>
    <p>Paragraph 1</p>
    <p>Paragraph 2</p>
    <p>Paragraph 3</p>
</div>
```
would be 
```
Paragraph 1
Paragraph 2
Paragraph 3
```

Basically, the text of a non leaf element is equal to the the text of all the leaf elements present in that 
HTML element combined.

So be it a Leaf element or a composite element, `text` method should be there but their handling would be different.
This means we're **treating them uniformly**. And in order to do that we've to create an interface with which the client
will interact. Using this interface the client will be able to treat both the objects uniformly.


This is our component class:
```java
abstract class HTMLComponent {

    private String type;

    abstract String getText();

    abstract void setText(String text);

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addElement(HTMLComponent element) {
        throw new UnsupportedOperationException("The Element cannot have children nodes.");
    }

    abstract Iterator<HTMLComponent> iterator();
}
```

It is being extended by two classes:
- HTMLLeafElement: The class extends `setText`, `getText` and `iterator`. The `setText` and `getText` are pretty obvious
but the `iterator()` return a `BlankIterator` object that makes sure that no elements can be fetched from this leaf 
element because it returns `false` every time `hasNext()` is called.
```java
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
```
- HTMLCompositeElement: This class has the most interesting part. In order to get the text content from the child nodes
it calls the `getText()` method of it's children recursively.
```java
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
```





