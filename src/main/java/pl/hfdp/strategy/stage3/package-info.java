/**
 * This is the 3rd stage in the Strategy design pattern series.
 * <br>
 * So, we had a problem in the 2nd Stage and the problem was with
 * the Rubber Duck. Due to inheritance it inherited the fly behaviour
 * from the abstract class Duck and we had to override the fly
 * method of the it.
 * <br>
 * This problem is not small. Let's assume that there are a set of
 * algorithms for flying. A duck can use anyone of them. But here as
 * the method fly, with default fly algorithm, is part of super duck
 * we'll have to override each one of the Concrete duck's implementation
 * of fly method. In some scenarios multiple concrete ducks will use
 * the same flying algorithm but there will be copy-paste of code
 * because that algorithm needs to be in the method body of the duck.
 * <br>
 * So, we find out that the fly behaviour is one which is varying
 * as lot on duck by duck basis. Let's put this behaviour out then.
 * We'll create set of flying algorithms and the ducks will then
 * use it.
 * <br>
 * This way we'll separate out the attributes that stays the same from
 * the ones that vary a lot. The varying attributes will be converted into
 * a set of algorithms and it will be composed into the ducks.
 * <br>
 * The formal definition of what we've done:
 * <br>
 * <h1>
 * The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 * </h1>
 */
package pl.hfdp.strategy.stage3;