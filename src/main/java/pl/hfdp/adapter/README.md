
**Can a whiteboard pen be used as a simple pen to write on a paper?**

In this section we'll be looking into the **Adapter Design Pattern**.

Let's assume you've an existing software system that fetches the current INR(India Rupees) to USD(US Dollars) live 
exchange rates from current-rates.com. But one day you find that the your system is not able to get the current exchange
rates.

After some research you found that response that your system expects is different from the actual response. 
Maybe, the exchange rate service has added a new field in the message. Anyway, it's your system that got impacted.

What can you do to solve this problem?

- You can update your system's code by changing the message format. But you'll have to keep on doing it whenever 
  there's a change in the exchange rate service. 
  Also, this is possible if and only if you can change the code of the receiver, i.e., your software system.
- You can create an adapter that adapts to the exchange rate service. So, whenever there's a change in the exchange rate
  service the adapter makes sure that your software system receives the response in the expected format only.   
  
  [Simple Adapter]("https://www.codiwan.com/img/adapter-pattern/Simple-Adapter.png")
  
  Also, whenever the exchange rate service change their response there won't be any impact on the your system as the 
  changes will be handled(or adapted) by the Adapter.

**Here's how it'll work:**
- The client(that is you) will have an interface, `ExchangeRateAPI`, for communicating with the exchange rate APIs.
- The exchange rate guys will provide a class, `ExchangeRateAPIManager`, to you so that you can hit their APIs.
- The adapter comes into play here. It will implement `ExchangeRateAPI` and it will have a has-a relationship with the 
  `ExchangeRateAPIManager`.
- Whenever you require to know the current rates, you will use your interface to get it. The adapter will be triggered 
  as it implements the interface. It uses the object of the ExchangeRateAPIManager to get the latest rate and returns 
  the response as directed by the ExchangeRateAPI.
 
 [Class Diagram Adapter]("https://www.codiwan.com/img/adapter-pattern/Class-Diagram-Adapter.png")
 
Let's take a look at an another scenario where Adapter Design pattern can be help. 

Some Java classes, like, `Stack`, have method `elements()` that returns an `Enumeration`. The `Enumeration` interface 
has two methods, `hasMoreElements` and `nextElement`. It's there since JDK 1.0.

But Java has moved on and it brought `Iterator` in the Collection framework. But in a lot of APIs you can still find 
Enumerations being used. What we can do here is we can create an adapter for Enumerations so that when the client is an 
Iterable interface then it can use the Adapter so that **Enumerations get adapted into Iterables**.

```java
/**
 * EnumerationIterator is an adapter for Enumerations. It uses Iterables internally.
 */
class EnumerationIterator<T> implements Enumeration<T> {

    private Iterator<T> iterator;

    public EnumerationIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public T nextElement() {
        return iterator.next();
    }

}
```

and the vice versa as well:


```java
/**
 * IteratorEnumeration is an adapter for Iterator. It uses Iterables Enumeration.
 */
class IteratorEnumeration<T> implements Iterator<T> {

    private Enumeration<T> enumeration;

    public IteratorEnumeration(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public T next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Enumerations do not support removal of elements.");
    }
}
```