/**
 * The problem that we encountered in the previous stage is the ever changing Beverage
 * class. Whenever a new type of condiment will be added then the Beverage class will
 * require a change. And it violates the following principle.
 * <br/>
 * <b>Classes should be open for extension, but closed for modification.</b>
 * <br/>
 * If we keep on changing the parent class then concrete classes will also have to handle
 * the changes.
 * <br/>
 * Also, there are methods which do not seem fit for the classes, like, whip() for the
 * BlackCoffee class. This make the user to keep a watch on the usage of this method and
 * it is bad because this method should not even be available to be used in the first place
 * for this class.
 * <br/>
 * So solve these problems let's look into the <b>Decorator Design Pattern</b>.
 * <pre>
 *                                                    __________
 *                                                   | Beverage |
 *                                                   |----------|
 *                                                   |desription|
 *                        |------------------------> |----------|
 *                        |                |-------> |  cost()  |
 *                   _____|                |         |----------|<----------------
 *              ____|           ___________|          ^                          |
 *          ___|          _____|             _________|                          |
 *  ______._____    ______._____     ______._____                          ______._____________
 * | HouseBlend |  |  DarkRoast |   |  Espresso  |                        | CondimentDecorator |
 * |------------|  |------------|   |------------|                        |--------------------|
 * |    cost()  |  |    cost()  |   |    cost()  |                        |        cost()      |
 * |------------|  |------------|   |------------|     /----------------->|--------------------|
 *                                                   /                       ^                ^
 *                                                 /                       /                   \
 *                                     __________/_________    __________/_________    _________\_________
 *                                    |        Mocha       |  |         Soy        |  |        Whip        |
 *                                    |--------------------|  |--------------------|  |--------------------|
 *                                    | Beverage beverage  |  | Beverage beverage  |  | Beverage beverage  |
 *                                    |--------------------|  |--------------------|  |--------------------|
 *                                    |        cost()      |  |        cost()      |  |        cost()      |
 *                                    |  getDescription()  |  |  getDescription()  |  |  getDescription()  |
 *                                    |--------------------|  |--------------------|  |--------------------|
 * </pre>
 * This class diagram resembles out code structure.
 * <br/>
 * The classes Espresso, House Blend and Dark Roast extends Beverage class and then there's one more class,
 * CondimentDecorator, that will be extended by the Condiments. The condiments require a beverage because the
 * condiments cannot be served exclusively making the beverage a part of the constructor so that the condiments
 * creation cannot complete without a beverage.
 * <br/>
 * It can be noticed that the Condiments have a `has-a` relationship with the Beverages although they are
 * also a beverage.
 * <br/>
 * The condiments wrap a beverage and afterwards they are wrapped again by other condiments. This requires the
 * condiments to have the information about the beverage's cost API.
 * This makes the condiment a decorator as they are decorating the beverages. The decorated beverages can further
 * be decorated by other decorators.
 */
package pl.hfdp.decorator.stage3;