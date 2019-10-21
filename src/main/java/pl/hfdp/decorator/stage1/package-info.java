/**
 * In this chapter we'll go through the Decorator Design Pattern and we'll get know
 * about it by solving problem of a Coffee Ordering System.
 * <br>
 * This is stage 1 and it represents the first stage of the process through which we'll be
 * learning the Decorator design pattern.
 * So this Coffee Ordering System has multiple types of Coffees, like, House Blend, Espresso.
 * Along with the coffee there are condiments as well, like, Mocha, Milk, Soy and  Whipped Milk.
 * This means that there can be Espresso with Streamed Milk and Mocha or House Blend with soy and
 * whip. Actually, the number of Beverages that this system can make is pretty high which is equal to the
 * combination of each of the coffee type and condiments available.
 * <br>
 * The problem is to add all these types of beverages into the Coffee ordering system so that
 * it can take orders for all the available beverages.
 * <br>
 * How to do it?
 * <br>
 * Well, the very first solution that comes to the mind is to create a class of all these different types
 * of beverages. And that's what we'll do in this stage.
 * We've created an abstract class {@link pl.hfdp.decorator.stage1.Beverage} and the classes
 * {@link pl.hfdp.decorator.stage1.HouseBlend}, {@link pl.hfdp.decorator.stage1.DarkRoast},
 * {@link pl.hfdp.decorator.stage1.DecalWithSoyAndMocha},
 * {@link pl.hfdp.decorator.stage1.HouseBlendWithMochaAndStreamedMilk} that implement it.
 * <br/>
 * After implementing this easy solution we can see that there are a lot of issues present in this solution:
 * <ol>
 *     <li>There are lot of classes which means that there has been a <b>Class Explosion</b>.</li>
 *     <li>
 *         If we require to add a new coffee type or a new condiment type then we'll have to create
 *         multiple classes representing all the different types of combinations.
 *     </li>
 *     <li>
 *         It can lead to maintenance nightmare.
 *     </li>
 * </ol>
 */
package pl.hfdp.decorator.stage1;