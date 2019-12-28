/**
 * In this chapter we will look into
 * <ol>
 *     <li>Simple Factory Pattern(or an Idiom?)</li>
 *     <li>Factory Method Pattern</li>
 *     <li>Abstract Factory Pattern</li>
 * </ol>
 * <p>
 *     We'll try to code a Milk Shake Factory and use it for implementing the above mentioned patterns. Like the earlier
 *     chapter we'll be dividing this chapter into multiple stages and we'll progress from one stage to another by
 *     adding new concepts.
 * </p>
 * <h3>
 *     Stage 1
 * </h3>
 * <p>
 *     In this stage we'll be creating a simple Milk Shake shop. Our {@link pl.hfdp.factory.simple.stage1.MilkShakeShop} has a
 *     method {@link pl.hfdp.factory.simple.stage1.MilkShakeShop#orderShake(java.lang.String)} that accepts a String parameter
 *     for the type of the MilkShake. Afterwards, it creates an object based on the argument and then adds the other
 *     ingredients and blends it before returning it back to the client.
 * </p>
 */
package pl.hfdp.factory.simple.stage1;