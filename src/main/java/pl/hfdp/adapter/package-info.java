/**
 * <b>Can a whiteboard pen be used as a simple pen to write on a paper?</b>
 * <p>
 * In this chapter we'll be looking into the <b>Adapter Design Pattern</b>.
 * <p>
 * Let's assume you've an existing software system that fetches the current INR(India Rupees) to USD(US Dollars) live
 * exchange rates from current-rates.com. But one day you find that the your system is not able to get the current
 * exchange rates.
 * <p>
 * After some research you've found that response that your system expects is different from the actual response. Maybe,
 * the exchange rate service has added a new field in the message. Anyway, it's your system that got impacted.
 * <p>
 * What can you do to solve this problem?
 * <ol>
 *     <li>
 *         You can update your system's code by changing the message format. But you'll have to keep on doing it whenever
 *         there's a change in the exchange rate service. Also, this is possible if and only if you can change the code
 *         of the receiver, i.e., your software system.
 *     </li>
 *     <li>
 *         You can create an adapter that adapts to the exchange rate service. So, whenever there's a change in the
 *         exchange rate service the adapter makes sure that your software system receives the response in the expected
 *         format only.
 *
 *         <img src="./doc-files/CommandWireframe.png">
 *         Also, whenever the exchange rate service change their response there won't be any impact on the your system
 *         as the changes will be handled(or adapted) by the Adapter.
 *     </li>
 * </ol>
 * <p>
 * Here's how it'll work:
 * <ol>
 *     <li>
 *         The client(that is you) will have an interface, ExchangeRateAPI, for communicating with the exchange rate APIs.
 *     </li>
 *     <li>
 *          The exchange rate guys will provide a class, ExchangeRateAPIManager, to you so that you can hit their APIs.
 *     </li>
 *     <li>
 *         The adapter comes into play here. It will implement ExchangeRateAPI and it will have a has-a relationship
 *         with the ExchangeRateAPIManager.
 *     </li>
 *     <li>
 *         Whenever you require to know the current rates, you will use your interface to get it. The adapter will be
 *         triggered as it implements the interface. It uses the object of the ExchangeRateAPIManager to get the latest
 *         rate and returns the response as directed by the ExchangeRateAPI.
 *     </li>
 * </ol>
 * <img src="./doc-files/Class-Diagram-Adapter.png">
 * <p>
 * Let's take a look at an another scenario where Adapter Design pattern can be help. Some Java classes, like, Stack,
 * have method `elements()` that returns an Enumeration. The Enumeration interface has two methods, hasMoreElements and
 * nextElement. It's there since JDK 1.0.
 * <p>
 * But Java has moved on and it brought Iterator in the collection framework. But in a lot of APIs you can still find
 * Enumerations being used.
 * <p>
 * What we can do here is we can create an adapter for Enumerations so that when the client is an Iterable interface
 * then it can use the Adapter so that Enumerations get adapted into Iterables.
 */
package pl.hfdp.adapter;