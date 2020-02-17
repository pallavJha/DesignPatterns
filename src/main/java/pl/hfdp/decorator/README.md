In this chapter we'll go through the Decorator Design Pattern and we'll get know about it by solving problem 
for a Coffee Ordering System. 

This is stage 1 and it represents the first stage of the process through which we'll be learning the 
Decorator design pattern. 
So this Coffee Ordering System has multiple types of Coffees, like, House Blend, Espresso. Along with the coffee 
there are condiments as well, like, Mocha, Milk, Soy and Whipped Milk. 
This means that there can be Espresso with Streamed Milk and Mocha or House Blend with soy and whip. 
Actually, the number of Beverages that this system can make is pretty high which is equal to the combination of each 
of the coffee type and condiments available. 

The problem is to add all these types of beverages into the Coffee ordering system so that it can take orders for all 
the available beverages. 

How to do it? 

Well, the very first solution that comes to the mind is to create a class of all these different types of beverages. 
And that's what we'll do in this stage. 

We've created an `abstract` class `Beverage` and the classes `HouseBlend`, `DarkRoast`, `DecalWithSoyAndMocha`, 
`HouseBlendWithMochaAndStreamedMilk` that implement it. After implementing this easy solution we can see that 
there are a lot of issues present in this solution:

- There are lot of classes which means that there has been a **Class Explosion**.
- If we require to add a new coffee type or a new condiment type then we'll have to create multiple classes 
  representing all the different types of combinations.
- It can lead to **maintenance nightmare**.

```java
package pl.hfdp.decorator.stage1;

/**
 * Super class of all the beverages.
 * <br/>
 * It is an abstract class because the {@link Beverage#cost()} needs to be overridden by the
 * concrete implementations.
 * ☕
 */
abstract class Beverage {
    /**
     * The description of the beverage.
     */
    private String description;

    Beverage() {
        description = "Sample Beverage.";
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}

/**
 * Extending the Beverage class, the HouseBlend coffee overrides the cost method.
 */
class HouseBlend extends Beverage {

    private String description;

    HouseBlend() {
        this.description = "House Blend";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 10.5;
    }
}

/**
 * One more type of a Coffee
 */
class DarkRoast extends Beverage {

    private String description;

    DarkRoast() {
        this.description = "Dark Roast";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 5.6;
    }
}

/**
 * House Blend Coffee With Mocha And Streamed Milk
 */
class HouseBlendWithMochaAndStreamedMilk extends Beverage {

    private String description;

    HouseBlendWithMochaAndStreamedMilk() {
        this.description = "House Blend With Mocha And Streamed Milk";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 11.45;
    }
}

/**
 * Decal With Soy And Mocha
 */
class DecalWithSoyAndMocha extends Beverage {

    private String description;

    DecalWithSoyAndMocha() {
        this.description = "Decal With Soy And Mocha";
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public double cost() {
        return 9.44;
    }
}
```

One of the problems that we faced in the previous stage is the huge number of class. 
**Can we bring it down?** 

We can notice that there are 4 condiments and it's just their availability that is contributing to the class explosion. 
We can try to lower the number of classes present by adding the condiment's availability into the super class, Beverage.

Afterwards, the concrete coffee types can implement the `Beverage.cost()` to add their own cost after the Beverage has 
added the cost of the applied condiments. This way we don't require a lot of classes which also solves out maintenance 
problem. 

Now that we've provided a fix for it can we assume that we've solved our problems? Let's look into the current problems:
- While we've reduced the number of classes required but we'll need to keep on updating the Beverage class for changes like, cost of Milk or cost of Mocha.
- If there's a new condiment then we'll need to alter the beverage class.
- What if there's a double mocha?
- setWhip() method doesn't seem appropriate for IceTea.

```java
package pl.hfdp.decorator.stage2;

class Beverage {

    private boolean milk;

    private boolean soy;

    private boolean mocha;

    private boolean whip;

    void setMilk() {
        this.milk = true;
    }

    void setSoy() {
        this.soy = true;
    }

    void setMocha() {
        this.mocha = true;
    }

    void setWhip() {
        this.whip = true;
    }

    double cost() {
        return 0D + (this.milk ? 1 : 0) +
                (this.soy ? 1 : 0) + (this.mocha ? 1 : 0) +
                (this.whip ? 1 : 0);
    }
}

class HouseBlend extends Beverage {

    @Override
    double cost() {
        return 10.5 + super.cost();
    }
}

class DarkRoast extends Beverage {

    @Override
    double cost() {
        return 5.6 + super.cost();
    }
}

class Decaf extends Beverage {

    @Override
    double cost() {
        return 11.23 + super.cost();
    }
}

class Espresso extends Beverage {

    @Override
    double cost() {
        return 3.55 + super.cost();
    }
}
```
The problem that we encountered in the previous stage is the ever changing Beverage class. 
Whenever a new type of condiment will be added then the Beverage class will require a change. 
And it violates the following principle. 
> Classes should be open for extension, but closed for modification.

If we keep on changing the parent class then concrete classes will also have to handle the changes. Also, there are 
methods which do not seem fit for the classes, like, whip() for the BlackCoffee class. 
This make the user to keep a watch on the usage of this method and it is bad because this method should not even be 
available to be used in the first place for this class. So solve these problems let's look into the 
**Decorator Design Pattern**.

```diagram
                                                      __________
                                                     | Beverage |
                                                     |----------|
                                                     |desription|
                          |------------------------> |----------|
                          |                |-------> |  cost()  |
                     _____|                |         |----------|<----------------
                ____|           ___________|          ^                          |
            ___|          _____|             _________|                          |
    ______._____    ______._____     ______._____                          ______._____________
   | HouseBlend |  |  DarkRoast |   |  Espresso  |                        | CondimentDecorator |
   |------------|  |------------|   |------------|                        |--------------------|
   |    cost()  |  |    cost()  |   |    cost()  |                        |        cost()      |
   |------------|  |------------|   |------------|     /----------------->|--------------------|
                                                     /                       ^                ^
                                                   /                       /                   \
                                       __________/_________    __________/_________    _________\_________
                                      |        Mocha       |  |         Soy        |  |        Whip        |
                                      |--------------------|  |--------------------|  |--------------------|
                                      | Beverage beverage  |  | Beverage beverage  |  | Beverage beverage  |
                                      |--------------------|  |--------------------|  |--------------------|
                                      |        cost()      |  |        cost()      |  |        cost()      |
                                      |  getDescription()  |  |  getDescription()  |  |  getDescription()  |
                                      |--------------------|  |--------------------|  |--------------------|
```

This class diagram resembles out code structure. 

The classes Espresso, House Blend and Dark Roast extends Beverage class and then there's one more class, 
CondimentDecorator, that will be extended by the Condiments. The condiments require a beverage because the condiments 
cannot be served exclusively making the beverage a part of the constructor so that the condiments creation cannot 
complete without a beverage. 

It can be noticed that the Condiments have a `has-a` relationship with the Beverages although they are also a beverage. 

The condiments wrap a beverage and afterwards they are wrapped again by other condiments. This requires the condiments 
to have the information about the beverage's cost API. This makes the condiment a decorator as they are decorating the 
beverages. The decorated beverages can further be decorated by other decorators.