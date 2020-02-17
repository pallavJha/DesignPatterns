It represents the stage1 of the process through which we'll be learning Strategy design pattern.
 The package contains the classes Duck, MallardDuck and RedHeadDuck.
In this package all the concrete duck implementation override the `Duck.display()` method because 
all the ducks appear differently. 

The other methods, `Duck.quack()` and `Duck.swim()` are not overridden because this behaviour remains 
the same throughout all the ducks.

```java
package pl.hfdp.strategy.stage1;

/**
 * 🦆
 *
 * In real world there aren't any simple ducks.
 * That's why it is an abstract duck.
 */
abstract class Duck {
    /**
     * All ducks can quack and the implementation of quack is same for all
     * of the ducks. So this method is a part of the superclass
     *
     * @return Quack!
     */
    public String quack() {
        return "Quack!";
    }

    /**
     * Like the method {@link #quack()}, swim can also be taken care of by the
     * Superclass
     *
     * @return Swim!
     */
    public String swim() {
        return "Swim!";
    }

    /**
     * As different ducks look different, this method will be overridden by the concrete
     * implementations
     *
     * @return how the duck looks like
     */
    abstract public String display();

}

/**
 * The mallard is a dabbling duck that breeds throughout the temperate and subtropical Americas,
 * Eurasia, and North Africa and has been introduced to New Zealand, Australia, Peru, Brazil, Uruguay,
 * Argentina, Chile, Colombia, the Falkland Islands, and South Africa.
 */
class MallardDuck extends Duck {

    /**
     * This method defines the display properties of a mallard duck.
     * I understand that the implementation of this method can't be
     * better.
     *
     * @return the way the Mallard Duck Looks
     */
    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

/**
 * The redhead is a medium-sized diving duck.
 * The scientific name is derived from Greek aithuia an unidentified seabird mentioned by authors 
 * including Hesychius and Aristotle, and Latin americana, of America.
 * <p>
 * The redhead is 37 cm long with an 84 cm wingspan.
 */
class RedHeadDuck extends Duck {

    /**
     * This method defines the display properties of a Red Head Duck.
     * Like any other Duck it swims but it has a red head.
     *
     * @return the way the red head looks
     */
    @Override
    public String display() {
        return "Red head Duck has a red head!";
    }
}
```
This is the 2nd Stage in the Strategy design pattern series. 
Once our base(or the ducks) is set we can proceed forward to solve problems. 

**Problem**: As we know that the ducks can fly. So, implement that!

**Solution**(Not the actual one): As all the ducks have got the wings so they can fly. 

There seems to be an obvious solution to it then. Let's make a fly method inside the duck class and all the other 
concrete ducks will be able to fly.

```java
package pl.hfdp.strategy.stage2;

/**
 * 🦆
 */
abstract class Duck {

    public String quack() {
        return "Quack!";
    }

    public String swim() {
        return "Swim!";
    }

    /**
     * This method will be inherited by all the concrete ducks
     * and it will enable each of their objects to fly.
     *
     * @return the way the ducks fly
     */
    public String fly() {
        return "Fly!";
    }

    abstract public String display();
}

class MallardDuck extends Duck {

    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

class RedHeadDuck extends Duck {

    @Override
    public String display() {
        return "Red head Duck has a red head!";
    }
}

/**
 * 🐤
 * Rubber Duck is added to the catalogue of ducks because
 */
class RubberDuck extends Duck {

    @Override
    public String display() {
        return "Rubber duck is yellow!";
    }

    /**
     * This is a Rubber Duck and it cannot fly(naturally). As the {@link pl.hfdp.strategy.stage2.Duck}
     * already has the method fly, that behaviour was inherited by the Rubber Duck.
     * <br>
     * To stop that we have to override the {@link pl.hfdp.strategy.stage2.Duck#fly()} method of the Rubber Duck.
     *
     * @return actually, nothing
     * @throws UnsupportedOperationException because a rubber duck cannot fly
     */
    @Override
    public String fly() {
        throw new UnsupportedOperationException("a rubber duck cannot fly");
    }
}
```

This is the 3rd stage in the Strategy design pattern series.

So, we had a problem in the 2nd Stage and the problem was with the Rubber Duck. Due to inheritance it inherited the 
fly behaviour from the abstract class Duck and we had to override the fly method of the it.

This problem is not small. Let's assume that there are a set of algorithms for flying. A duck can use anyone of them. 
But here as the method fly, with default fly algorithm, is part of super duck we'll have to override each one of the 
Concrete duck's implementation of fly method. 

In some scenarios multiple concrete ducks will use the same flying algorithm but there will be copy-paste of code 
because that algorithm needs to be in the method body of the duck. 

So, we find out that the fly behaviour is one which is varying as lot on duck by duck basis. 
Let's put this behaviour out then. We'll create set of flying algorithms and the ducks will then use it. 
This way we'll separate out the attributes that stays the same from the ones that vary a lot. 
The varying attributes will be converted into a set of algorithms and it will be composed into the ducks. 

_The definition from the Wikipedia_ 

> In computer programming, the strategy pattern (also known as the policy pattern) is a behavioral software design 
> pattern that enables selecting an algorithm at runtime. Instead of implementing a single algorithm directly, code 
> receives run-time instructions as to which in a family of algorithms to use.

```java
package pl.hfdp.strategy.stage3;

/**
 * This is the extracted out behaviour.
 * Multiple concrete behaviours will be used by the {@link Duck} class to
 * execute it's performFly method.
 * <br>
 * This behaviour is a must have for a duck.
 */
interface FlyBehaviour {
    String fly();
}

/**
 * This algorithm utilized the wings to fly.
 * ✈️
 */
class FlyWithWings implements FlyBehaviour {

    @Override
    public String fly() {
        return "fly with two wings";
    }
}

/**
 * Does not fly.
 * 🥝
 */
class FlyNoWay implements FlyBehaviour {

    @Override
    public String fly() {
        return "cannot fly";
    }
}

abstract class Duck {

    private FlyBehaviour flyBehaviour;

    /**
     * @param flyBehaviour pass the flyBehaviour object that will be used to fly
     */
    Duck(FlyBehaviour flyBehaviour) {
        if (flyBehaviour != null) {
            this.flyBehaviour = flyBehaviour;
        } else {
            throw new UnsupportedOperationException("a duck cannot be created with null fly behaviour");
        }
    }

    public String quack() {
        return "Quack!";
    }

    public String swim() {
        return "Swim!";
    }

    /**
     * Here the {@link #flyBehaviour} would be used. This method calls
     * the {@link FlyBehaviour#fly()} of the passed behaviour.
     * <p>
     * <br>
     * This method will be inherited by all the concrete ducks
     * and it will enable each of their objects to fly.
     *
     * @return the way the ducks fly
     */
    String performFly() {
        return flyBehaviour.fly();
    }

    abstract public String display();
}

class MallardDuck extends Duck {

    MallardDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Looks like a Mallard Duck!";
    }
}

class RedHeadDuck extends Duck {

    RedHeadDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Red head Duck has a red head!";
    }
}

/**
 * 🐤
 * Rubber Duck is added to the catalogue of ducks because
 */
class RubberDuck extends Duck {

    RubberDuck(FlyBehaviour flyBehaviour) {
        super(flyBehaviour);
    }

    @Override
    public String display() {
        return "Rubber duck is yellow!";
    }
}
```