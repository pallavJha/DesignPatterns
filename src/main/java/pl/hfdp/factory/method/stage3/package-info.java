/**
 * In the Simple Factory Pattern(or an Idiom?) we tried to delegate the task of creating and instantiating objects,
 * i.e. MilkShakes, to a different object and we called it a Simple Factory.
 * <br/>
 * Well there's one more way to deal with it by delegating the task to creating objects to the sub classes.
 * <br/>
 * Let's imagine a scenario in which there are multiple franchisees that require the Milk Cake Shop. These franchisees
 * have no idea about how to create the Milk Shakes but they know the customers from their area and they know what to
 * sell.
 * To solve this problem we've two possible solutions:
 * <ol>
 *     <li>
 *         We can ask them to send the types of Milk Shakes that they would want and then we can add them to our factory.
 *         This requires us to update the MilkShakeFactory class by adding the code to create the specific types of Milk
 *         shakes.
 *         <br/>
 *         This looks easy but there are some problems here.
 *         <ol>
 *             <li>
 *                  We'll have to keep on releasing new version of our Milk shake Factory so that all our client are
 *                  always up to date with all the available milk shake types.
 *             </li>
 *             <li>
 *                 There would be some Milk Shake types that one franchisee would not like to share with other
 *                 franchisees. But if we keep on adding the all the Milk Shake types to the same factory then we might
 *                 not be able to do so.
 *             </li>
 *         </ol>
 *     </li>
 *     <li>
 *         We can convert MilkShakeShop class to an abstract class by making the method `createMilkShake` abstract.
 *         The franchisees can then override it and create the Milk Shakes that they require. This way Milk shake types
 *         will remain private for the franchisees and we won't have to keep on releasing newer libraries.
 *     </li>
 * </ol>
 */
package pl.hfdp.factory.method.stage3;