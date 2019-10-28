/**
 * One of the problems that we faced in the previous stage is the huge number of class.
 * <br/>
 * <b>Can we bring it down?</b>
 * <br/>
 * We can notice that there are 4 condiments and it's just their availability that is
 * contributing to the class explosion. We can try to lower the number of classes present
 * by adding the condiment's availability into the super class, {@link pl.hfdp.decorator.stage2.Beverage}.
 * <br/>
 * Afterwards, The concrete coffee types can implement the {@link pl.hfdp.decorator.stage2.Beverage#cost()}
 * to add their own cost after the {@link pl.hfdp.decorator.stage2.Beverage} has added the cost of
 * the applied condiments.
 * <br/>
 * This way we don't require a lot of classes which also solves out maintenance problem.
 * <br/>
 * Now that we've provided a fix for it can we assume that we've solved our problems?
 * <br/>
 * Let's look into the current problems:
 * <ol>
 *     <li>
 *        While we've reduced the number of classes required but we'll need to keep on updating the Beverage class
 *        for changes like, cost of Milk or cost of Mocha.
 *     </li>
 *     <li>
 *         If there's a new condiment then we'll need to alter the beverage class.
 *     </li>
 *     <li>
 *         What if there's a double mocha?
 *     </li>
 *     <li>
 *         setWhip() method doesn't seem appropriate for IceTea.
 *     </li>
 * </ol>
 */
package pl.hfdp.decorator.stage2;