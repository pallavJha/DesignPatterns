From this tutorial we will look into Factory Method Design Pattern. This tutorial expects that you've already gone 
through [Simple Factory Pattern](https://www.codiwan.com/posts/design-patterns/simple-factory-pattern/).

In the Simple Factory Pattern(or an Idiom?) we tried to delegate the task of creating and instantiating objects, 
i.e. MilkShakes, to a different object and we called it a Simple Factory. 

Well, there's one more way to deal with it by delegating the task to creating objects to the sub classes. 

Let's imagine a scenario in which there are multiple franchisees that require the Milk Cake Shop. 
These franchisees have no idea about how to create the Milk Shakes but they know the customers from their area and they 
know what to sell. 

To solve this problem we've two possible solutions:
- We can ask them to send the types of Milk Shakes that they would want and then we can add them to our factory. 
  This requires us to update the MilkShakeFactory class by adding the code to create the specific types of Milk shakes. 
  
  This looks easy but there are some problems here.
  - We'll have to keep on releasing new version of our Milk shake Factory so that all our client are always up to date 
    with all the available milk shake types.
  - There would be some Milk Shake types that one franchisee would not like to share with other franchisees. 
    But if we keep on adding the all the Milk Shake types to the same factory then we might not be able to do so.

- We can convert MilkShakeShop class to an abstract class by making the method `createMilkShake` abstract. 
  The franchisees can then override it and create the Milk Shakes that they require. This way Milk shake types will 
  remain private for the franchisees and we won't have to keep on releasing newer libraries.
  
In the code below there are two franchisees `DelhiMilkShakeShop` and `MumbaiMilkShakeShop` that extend `MilkCakeShop`.
The `DelhiMilkShakeShop` only wants to sell the `StrawBerryMilkShake` and the `MumbaiMilkShakeShop` doesn't sell the 
`StrawberryMilkShake` but sells the `ChocolateMilkShake` and `BananaMilkShake`.
  
```java

/**
 * This new milk cake shop is delegating the object creation process to its concrete classes.
 */
abstract class MilkShakeShop {

    /**
     * The classes {@link DelhiMilkShakeShop} and {@link MumbaiMilkShakeShop} will implement this method.
     *
     * @param type type of the milk shake
     * @return a concrete Milk Shake
     */
    abstract MilkShake createMilkShake(String type);

    MilkShake orderShake(String type) {
        MilkShake milkShake;

        milkShake = createMilkShake(type);

        milkShake.addMilk();
        milkShake.addIngredients();
        milkShake.blend();

        return milkShake;
    }
}

class DelhiMilkShakeShop extends MilkShakeShop {

    /**
     * Delhi Milkshake shop only serves Strawberry Milkshakes
     *
     * @param type type of the milk shake
     * @return Milkshake
     */
    MilkShake createMilkShake(String type) {
        MilkShake milkShake;
        if (StrawBerryMilkShake.name().equals(type)) {
            milkShake = new StrawBerryMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }
        return milkShake;
    }
}

class MumbaiMilkShakeShop extends MilkShakeShop {

    /**
     * Mumbai Milkshake shop serves Banana MilkShake and Chocolate Milkshake
     *
     * @param type type of the milk shake
     * @return Milkshake
     */
    MilkShake createMilkShake(String type) {
        MilkShake milkShake;
        if (ChocolateMilkShake.name().equals(type)) {
            milkShake = new ChocolateMilkShake();
        } else if (BananaMilkShake.name().equals(type)) {
            milkShake = new BananaMilkShake();
        } else {
            throw new RuntimeException("the passed milk shake type is not available with us.");
        }
        return milkShake;
    }
}

```
